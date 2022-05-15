package acme.features.inventor.patronageReport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport> {

	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorPatronageReportRepository repository;

	// AbstractListService<Inventor, PatronageReport> interface ---------------------------

	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;

		boolean result;
		int patronageId;
		Patronage patronage;

		patronageId = request.getModel().getInteger("patronageId");
		patronage = this.repository.findPatronageById(patronageId);
		result = request.getPrincipal().getActiveRoleId() == patronage.getInventor().getId();

		return result;
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;

		PatronageReport result;
		int patronageId;
		Patronage patronage;
		Date date;
		String numPatronageReports;		
		
		patronageId = request.getModel().getInteger("patronageId");
		patronage = this.repository.findPatronageById(patronageId);
		date = new Date();
		numPatronageReports = Integer.toString(this.repository.findPatronageReportByPatronageId(patronageId).size()+1);
		
		result = new PatronageReport();
		result.setPatronage(patronage);
		result.setCreationMoment(date);
		result.setSerialNumber("000"+ numPatronageReports);

		return result;
	}
	
	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors,"memorandum","link");
		
	}
	
	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final Boolean isConfirmed = request.getModel().getBoolean("confirm");
		errors.state(request, isConfirmed, "confirm", "inventor.patronage-report.form.error.must-confirm");
	}
	
	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "serialNumber","creationMoment","memorandum","link");
		model.setAttribute("patronageId", request.getModel().getAttribute("patronageId"));
		model.setAttribute("sequenceNumber", entity.getSequenceNumber());
		model.setAttribute("confirm", "false");
	}	

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}

}