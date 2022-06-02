package acme.features.inventor.quantity;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.ArtifactType;
import acme.entities.artifacts.Quantity;
import acme.entities.artifacts.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorQuantityCreateService  implements AbstractCreateService<Inventor,Quantity>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;
	
	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		final Integer toolkitId = request.getModel().getInteger("toolkitId");
		final Toolkit toolkit = this.repository.findToolkitById(toolkitId);
		final Integer activeId = request.getPrincipal().getActiveRoleId();
		final boolean publishedArtifacts = !this.repository.findPublishedArtifacts().isEmpty();
		
		return (!toolkit.isPublished() && toolkit.getInventor().getId()==activeId && publishedArtifacts);	
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		Integer artifactId;
		Artifact artifact;
		
		artifactId = request.getModel().getInteger("artifactId");
		artifact = this.repository.findArtifactById(artifactId);	

		entity.setArtifact(artifact);
		request.bind(entity, errors, "amount");
		
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;		
		
		List<Artifact> publishedArtifacts;	
		publishedArtifacts = this.repository.findPublishedArtifacts();
		
		request.unbind(entity, model, "amount");
		model.setAttribute("toolkitId", request.getModel().getAttribute("toolkitId"));
		model.setAttribute("artifacts", publishedArtifacts);
		model.setAttribute("published", entity.getToolkit().isPublished());
		
		
	}

	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request != null;

		Integer toolkitId;
		Toolkit toolkit;
		final Artifact artifact;
		
		toolkitId = request.getModel().getInteger("toolkitId");
		toolkit = this.repository.findToolkitById(toolkitId);
		artifact = new Artifact();
		
		Quantity result;
		result = new Quantity();
		result.setToolkit(toolkit);
		result.setArtifact(artifact);

		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(entity.getArtifact().getArtifactType() == ArtifactType.TOOL) {
			errors.state(request, entity.getAmount()<=1, "*", "inventor.quantity.form.error.only-1-type-of-tool-allowed");
		}
		if(!errors.hasErrors("artifact.id")) {
			final Collection<Quantity> quantities = this.repository.findQuantitiesByToolkitId(entity.getToolkit().getId());
			final String artifactName = entity.getArtifact().getName();
			final boolean repeatedArtifact = quantities.stream()
										.anyMatch(x -> Objects.equal(x.getArtifact().getName(), artifactName));
			errors.state(request, !repeatedArtifact, "*", "inventor.quantity.form.error.repeated-artifact");
			
		}
		
		
	}

	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
			
		this.repository.save(entity);
	
	}

}