package acme.features.inventor.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class InventorPatronageUpdateStatusService implements AbstractUpdateService<Inventor, Patronage>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorPatronageRepository repository;
	
	// AbstractUpdateService<Inventor, Patronage> interface -------------------
	
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
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "status", "code", "legalStuff", "budget",
			"startDate", "finishDate", "link");
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Patron patron = entity.getPatron();
		final UserAccount patronAccount = patron.getUserAccount();
		final String patronLink = patron.getLink();
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget",
			"startDate", "finishDate", "link");
		
		model.setAttribute("company", patron.getCompany());
		model.setAttribute("statement", patron.getStatement());
		model.setAttribute("username", patronAccount.getUsername());
		model.setAttribute("patronageId", entity.getId());
		model.setAttribute("patronLink", patronLink);
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		
		Patronage result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findPatronageById(id);
		
		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		Status status;
		
		status = Status.valueOf(request.getModel().getString("status"));
		
		entity.setStatus(status);
		this.repository.save(entity);
	}

}
