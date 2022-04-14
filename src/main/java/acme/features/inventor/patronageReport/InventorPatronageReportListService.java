package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportListService implements AbstractListService<Inventor, PatronageReport> {

	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorPatronageReportRepository repository;

	// AbstractListService<Inventor, PatronageReport> interface ---------------------------

	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;

		boolean result;
		int patronageId;
		PatronageReport patronageReport;

		patronageId = request.getModel().getInteger("patronageId");
		patronageReport = this.repository.findPatronageReportByPatronageId(patronageId)
			.stream().findFirst().orElse(null);

		result = false;
		if(patronageReport != null)
			result = request.getPrincipal().getActiveRoleId() == patronageReport.getPatronage().getInventor().getId();

		return result;
	}

	@Override
	public Collection<PatronageReport> findMany(final Request<PatronageReport> request) {
		assert request != null;

		Collection<PatronageReport> reports;
		int patronageId;

		patronageId = request.getModel().getInteger("patronageId");
		reports = this.repository.findPatronageReportByPatronageId(patronageId);

		return reports;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "sequenceNumber", "creationMoment");
	}

}