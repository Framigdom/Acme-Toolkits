package acme.features.inventor.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class InventorPatronageShowService implements AbstractShowService<Inventor, Patronage>{

	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorPatronageRepository repository;

	// AbstractListService<Inventor, Patronage> interface ---------------------------------

	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		boolean result;
		int patronageId;
		Patronage patronage;

		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(patronageId);
		result = request.getPrincipal().getActiveRoleId() == patronage.getInventor().getId();

		return result;
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

		final Patron patron = entity.getPatron();
		final UserAccount patronAccount = patron.getUserAccount();
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget",
			"startDate", "finishDate", "link", "patron", "inventor");
		request.unbind(patron, model, "company", "statement", "link");
		request.unbind(patronAccount, model, "username");
		model.setAttribute("patronageId", entity.getId());
	}

}