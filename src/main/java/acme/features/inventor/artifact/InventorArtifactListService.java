package acme.features.inventor.artifact;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorArtifactListService implements AbstractListService<Inventor, Artifact>{
	
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
		
		int masterId;
		masterId = request.getModel().getInteger("toolkitId");
		
		return this.repository.findToolsAndComponentsByToolkitId(masterId);
		
	}

	@Override
	public void unbind(Request<Artifact> request, Artifact entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		Quantity quantity = this.repository.findQuantityByArtifactId(entity.getId());
		
		request.unbind(quantity, model, "amount");
		request.unbind(entity, model, "name", "retailPrice", "artifactType");
		model.setAttribute("fromToolkit", true);
		
	}

}
