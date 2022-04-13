package acme.features.inventor.patron;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class InventorPatronShowService implements AbstractShowService<Inventor, Patron>{

	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorPatronRepository repository;

	// AbstractListService<Patron, Patronage> interface ---------------------------------

	@Override
	public boolean authorise(final Request<Patron> request) {
		assert request != null;

		return true;
	}

	@Override
	public Patron findOne(final Request<Patron> request) {
		assert request != null;

		Patron patron;
		int patronId;

		patronId = request.getModel().getInteger("patronId");
		patron = this.repository.findPatronById(patronId);

		return patron;
	}

	@Override
	public void unbind(final Request<Patron> request, final Patron entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "company", "statement", "link");
	}

}