package acme.features.inventor.toolkit;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitRepository repository;

	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		Integer toolkitId;
		toolkitId = request.getModel().getInteger("id");
		final Integer inventorId = request.getPrincipal().getActiveRoleId();
		
		final Collection<Inventor> toolkitInventors = this.repository.findInventorsByToolkitId(toolkitId);
		
		return toolkitInventors.stream().anyMatch(x -> x.getId() == inventorId);
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;
	
		Integer id;
		Toolkit toolkit;
		id = request.getModel().getInteger("id");
		toolkit = this.repository.findToolkitById(id);
		
		return toolkit;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Integer id;
		id = request.getModel().getInteger("id");
		final Double price = this.repository.findToolkitPrice(id);
		model.setAttribute("price", price);
		
		
		request.unbind(entity, model, "title", "code", "description", "assemblyNotes", "link","published");
		
	}
	
}
