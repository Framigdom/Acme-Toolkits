package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageShowService implements AbstractShowService<Patron, Patronage>{

	// Internal state -------------------------------------------------------------------
	
	@Autowired
	protected PatronPatronageRepository repository;
	
	// AbstractListService<Patron, Patronage> interface ---------------------------------
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		
		Patronage patronage;
		int id;
		
		id = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(id);
		
		return patronage;
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget",
			"startDate", "finishDate", "link", "patron", "inventor");
		model.setAttribute("inventorId", entity.getInventor().getId());
		model.setAttribute("patronageId", entity.getId());
	}

}
