package acme.features.patron.inventor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronInventorShowService implements AbstractShowService<Patron, Inventor>{

	// Internal state -------------------------------------------------------------------
	
	@Autowired
	protected PatronInventorRepository repository;
		
	// AbstractListService<Patron, Patronage> interface ---------------------------------
	
	@Override
	public boolean authorise(final Request<Inventor> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Inventor findOne(final Request<Inventor> request) {
		assert request != null;
		
		Inventor inventor;
		int inventorId;
		
		inventorId = request.getModel().getInteger("inventorId");
		inventor = this.repository.findInventorById(inventorId);
		
		return inventor;
	}

	@Override
	public void unbind(final Request<Inventor> request, final Inventor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "company", "statement", "link");
	}

}
