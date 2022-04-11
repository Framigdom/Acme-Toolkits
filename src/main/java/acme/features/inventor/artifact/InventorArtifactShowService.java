package acme.features.inventor.artifact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorArtifactShowService implements AbstractShowService<Inventor, Artifact>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorArtifactRepository repository;

	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(Request<Artifact> request) {
		assert request != null;
		
		Integer id;
		Artifact artifact;
		boolean result;
		id = request.getModel().getInteger("id");
		artifact = repository.findArtifactById(id);
		
		result = request.getPrincipal().getActiveRoleId() == artifact.getInventor().getId();
		
		
		return result;
	}

	@Override
	public Artifact findOne(Request<Artifact> request) {
		assert request != null;
	
		Integer id;
		Artifact artifact;
		id = request.getModel().getInteger("id");
		artifact = repository.findArtifactById(id);
		
		return artifact;
	}

	@Override
	public void unbind(Request<Artifact> request, Artifact entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "artifactType", "link");
		
	}
	
}
