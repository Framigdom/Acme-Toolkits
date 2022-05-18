package acme.features.inventor.artifact;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorArtifactListMineService implements AbstractListService<Inventor, Artifact>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorArtifactRepository repository;

	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Artifact> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Artifact> findMany(final Request<Artifact> request) {
		final Principal principal = request.getPrincipal();
		final String type = request.getModel().getString("type");
		if (type.equals("component")) {
			return this.repository.findComponentsByInventorId(principal.getActiveRoleId());
		} else {
			return this.repository.findToolsByInventorId(principal.getActiveRoleId());
		}
		
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "retailPrice", "artifactType", "published");
		
	}
	
	@Override
	public void unbind(final Request<Artifact> request, final Collection<Artifact> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;
		
		model.setAttribute("type", request.getModel().getString("type"));
	}

}
