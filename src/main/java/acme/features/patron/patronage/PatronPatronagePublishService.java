package acme.features.patron.patronage;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronPatronagePublishService implements AbstractUpdateService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected PatronPatronageRepository repository;
	
	// AbstractUpdateService<Patron, Patronage> interface ---------------------
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		
		boolean result;
		int patronageId;
		Patronage patronage;
		
		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(patronageId);
		result = request.getPrincipal().getActiveRoleId() == patronage.getPatron().getId();
		
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		String inventorUsername;
		Inventor inventor;
		
		inventorUsername = (String) request.getModel().getAttribute("inventor");
		inventor = this.repository.findInventorByUsername(inventorUsername);
		
		request.bind(entity, errors, "startDate", "code", "legalStuff", "budget",
			"finishDate", "link");
		entity.setInventor(inventor);
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		List<Inventor> inventors;
		
		inventors = this.repository.findAllInventors();
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget",
			"startDate", "finishDate", "link", "draftMode", "inventor", "inventor.company", "inventor.statement",
			"inventor.link", "inventor.userAccount.username");
		
		model.setAttribute("inventors", inventors);
		model.setAttribute("patronageId", entity.getId());
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
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("code")) {
			Patronage exists;
			
			exists = this.repository.findPatronageByCode(entity.getCode());
			errors.state(request, exists== null || exists.equals(entity), "code", "patronage.patronage.form.error.duplicated");
		}
		
		if(!errors.hasErrors("startDate")) {
			Calendar calendar;
			
			calendar = new GregorianCalendar();
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			
			errors.state(request, entity.getStartDate().after(calendar.getTime()), "startDate", "patron.patronage.form.error.startDate");
		}
		
		if(!errors.hasErrors("finishDate")) {
			Calendar calendar;
			
			calendar = new GregorianCalendar();
			calendar.setTime(entity.getStartDate());
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			
			errors.state(request, entity.getFinishDate().after(calendar.getTime()), "finishDate", "patron.patronage.form.error.finishDate");
		}
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		entity.setDraftMode(false);
		this.repository.save(entity);
	}

}
