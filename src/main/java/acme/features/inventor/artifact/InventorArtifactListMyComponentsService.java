package acme.features.inventor.artifact;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.artifacts.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;


public class InventorArtifactListMyComponentsService implements AbstractListService<Inventor, Artifact>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorArtifactRepository repository;

	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(Request<Artifact> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Artifact> findMany(Request<Artifact> request) {
		Principal principal = request.getPrincipal();
		return this.repository.findComponentsByInventorId(principal.getActiveRoleId());
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "description", "retailprice", "artifactType");
		
	}

}
