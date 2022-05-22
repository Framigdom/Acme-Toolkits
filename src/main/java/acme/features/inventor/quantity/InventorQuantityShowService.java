package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Quantity;
import acme.entities.artifacts.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorQuantityShowService implements AbstractShowService<Inventor, Quantity>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;

	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		final Integer quantityId = request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findToolkitByQuantityId(quantityId);
		final Integer activeId = request.getPrincipal().getActiveRoleId();
		
		return (toolkit.getInventor().getId()==activeId);	
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;
	
		Integer id;
		Quantity quantity;
		id = request.getModel().getInteger("id");
		quantity = this.repository.findQuantityById(id);
		
		return quantity;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
				
		final Artifact artifact = this.repository.findArtifactByQuantityId(entity.getId());

		request.unbind(entity, model, "amount", "artifact.name");
		model.setAttribute("artifact.name", artifact.getName());
		model.setAttribute("artifact.code", artifact.getCode());
		model.setAttribute("artifact.technology", artifact.getTechnology());
		model.setAttribute("artifact.retailPrice", artifact.getRetailPrice());
		model.setAttribute("artifact.description", artifact.getDescription());
		model.setAttribute("artifact.artifactType", artifact.getArtifactType());
		model.setAttribute("artifact.link", artifact.getLink());
		model.setAttribute("published", entity.getToolkit().isPublished());
	}
}
