package acme.features.inventor.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorArtifactDeleteService implements AbstractDeleteService<Inventor, Artifact> {

	
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorArtifactRepository repository;

	// AbstractDeleteService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Artifact> request) {
		assert request != null;

		boolean result;
		int masterId;
		Artifact artifact;
		Inventor inventor;

		masterId = request.getModel().getInteger("id");
		artifact = this.repository.findArtifactById(masterId);
		inventor = artifact.getInventor();
		result =  request.isPrincipal(inventor);

		return result;
	}

	@Override
	public void bind(final Request<Artifact> request, final Artifact entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "name", "code", "technology" , "description" , "retailPrice", "artifactType", "link");
		
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model,"name", "code", "technology" , "description" , "retailPrice", "artifactType", "published", "link");
		
	}

	@Override
	public Artifact findOne(final Request<Artifact> request) {
		assert request != null;

		Artifact result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findArtifactById(id);

		return result;
	}

	@Override
	public void validate(final Request<Artifact> request, final Artifact entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void delete(final Request<Artifact> request, final Artifact entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
		
	}

}
