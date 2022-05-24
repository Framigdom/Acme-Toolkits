package acme.features.patron.patronage;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected PatronPatronageRepository repository;
		
	// AbstractCreateService<Patron, Patronage> interface ---------------------
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		
		return true;
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
		
		request.unbind(entity, model, "code", "legalStuff", "budget", "startDate",
			"finishDate", "link", "draftMode", "inventor", "inventor.company", "inventor.statement",
			"inventor.link", "inventor.userAccount.username");
		
		model.setAttribute("inventors", inventors);
		model.setAttribute("patronageId", entity.getId());
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;
		
		Patronage result;
		int patronId;
		Patron patron;
		
		patronId = request.getPrincipal().getActiveRoleId();
		patron = this.repository.findPatronById(patronId);
		
		result = new Patronage();
		result.setDraftMode(true);
		result.setPatron(patron);
		result.setStatus(Status.PROPOSED);
		
		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("code")) {
			Patronage exists;
			
			exists = this.repository.findPatronageByCode(entity.getCode());
			errors.state(request, exists== null, "code", "patronage.patronage.form.error.duplicated");
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
			
			boolean errorState = true;
			
			if (entity.getStartDate() != null) {		
				calendar = new GregorianCalendar();
				calendar.setTime(entity.getStartDate());
				calendar.add(Calendar.MONTH, 1);
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				errorState = entity.getFinishDate().after(calendar.getTime());
			}
			
			errors.state(request, errorState, "finishDate", "patron.patronage.form.error.finishDate");
		}
		
		if (!errors.hasErrors("budget")) {
			final String currency = entity.getBudget().getCurrency();
			final String currencyAvaliable = this.repository.acceptedCurrencies();
			boolean acceptedCurrency = false;
			
			for(final String cur: currencyAvaliable.split(",")) {
				acceptedCurrency = cur.trim().equalsIgnoreCase(currency);
				if(acceptedCurrency)
					break;
			}
			errors.state(request, entity.getBudget().getAmount() > 0 , "budget", "patron.patronage.form.error.negative-budget");
			errors.state(request,acceptedCurrency, "budget", "patron.patronage.form.error.negative-currency");
		}
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}

}
