package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.PatronageReport;
import acme.entities.patronage.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
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
		Patronage patronage;

		patronageId = request.getModel().getInteger("patronageId");
		patronage = this.repository.findPatronageById(patronageId);
		
		result = patronage.getInventor().getId() == request.getPrincipal().getActiveRoleId();
		result = result && !patronage.isDraftMode();
		result = result && patronage.getStatus().equals(Status.ACCEPTED);

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
	public void unbind(final Request<PatronageReport> request, final Collection<PatronageReport> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;
		
		
		model.setAttribute("patronageId", request.getModel().getInteger("patronageId"));
		
	}
	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("sequenceNumber", entity.getSequenceNumber());
		request.unbind(entity, model, "creationMoment");
	}

}