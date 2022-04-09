package acme.features.patron.patronageReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageReportShowService implements AbstractShowService<Patron, PatronageReport>{

	// Internal state -------------------------------------------------------------------
	
	@Autowired
	protected PatronPatronageReportRepository repository;
	
	// AbstractShowService<Patron, PatronageReport> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public PatronageReport findOne(final Request<PatronageReport> request) {
		assert request != null;
		
		final PatronageReport report;
		int reportId;
		
		reportId = request.getModel().getInteger("id");
		report = this.repository.findPatronageReportById(reportId);
		
		return report;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "sequenceNumber", "creationMoment", "memorandum", "link");
	}

}
