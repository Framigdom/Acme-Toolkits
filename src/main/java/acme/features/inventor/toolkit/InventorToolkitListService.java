package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorToolkitListService implements AbstractListService<Inventor, Toolkit>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitRepository repository;

	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(Request<Toolkit> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Toolkit> findMany(Request<Toolkit> request) {
		
		Principal principal = request.getPrincipal();
		return this.repository.findToolkitsByInventorId(principal.getActiveRoleId());
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "description");
		
	}

}
