package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitCreateService  implements AbstractCreateService<Inventor,Toolkit>{	
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitRepository repository;
	
	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		final Integer activeId = request.getPrincipal().getActiveRoleId();		
		final Collection<Integer> existingInventors = this.repository.findAllInventorId();		
		return  existingInventors.stream().anyMatch(x -> Objects.equals(x, activeId));
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "title", "code", "description", "assemblyNotes", "link");
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
				
		request.unbind(entity, model, "title", "code", "description", "assemblyNotes", "link","published");
		
		
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		assert request != null;

		final Integer activeId = request.getPrincipal().getActiveRoleId();	
		Toolkit result;
		result = new Toolkit();
		result.setPublished(false);
		result.setInventor(this.repository.findInventorById(activeId));

		return result;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	
	}



}
