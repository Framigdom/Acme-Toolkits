package acme.features.patron.patronDashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Status;
import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard> {

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected PatronPatronDashboardRepository repository;
	
	// AbstractShowService<Patron, PatronDashboard> interface -----------------
	
	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;
		
		final PatronDashboard result;
		int patronId;
		int	totalNumberofProposedPatronages;
		int	totalNumberofAcceptedPatronages;
		int	totalNumberofDeniedPatronages;
		Map<Pair<Status,String>,Double> averageBudgetOfPatronagesGroupedByStatusAndCurrency;
		Map<Pair<Status,String>,Double> deviationBudgetOfPatronagesGroupedByStatusAndCurrency;
		Map<Pair<Status,String>,Double> minimumBudgetOfPatronagesGroupedByStatusAndCurrency;
		Map<Pair<Status,String>,Double> maximumBudgetOfPatronagesGroupedByStatusAndCurrency;
		
		patronId = request.getPrincipal().getActiveRoleId();
		totalNumberofProposedPatronages = this.repository.totalNumberofProposedPatronages(patronId);
		totalNumberofAcceptedPatronages = this.repository.totalNumberofAcceptedPatronages(patronId);
		totalNumberofDeniedPatronages = this.repository.totalNumberofDeniedPatronages(patronId);
		
		averageBudgetOfPatronagesGroupedByStatusAndCurrency = this.getStatisticMapByList(
			this.repository.averageBudgetOfPatronagesGroupedByStatusAndCurrency(patronId));
		deviationBudgetOfPatronagesGroupedByStatusAndCurrency = this.getStatisticMapByList(
			this.repository.deviationBudgetOfPatronagesGroupedByStatusAndCurrency(patronId));
		minimumBudgetOfPatronagesGroupedByStatusAndCurrency = this.getStatisticMapByList(
			this.repository.minimunBudgetOfPatronagesGroupedByStatusAndCurrency(patronId));
		maximumBudgetOfPatronagesGroupedByStatusAndCurrency = this.getStatisticMapByList(
			this.repository.maximunBudgetOfPatronagesGroupedByStatusAndCurrency(patronId));
		
		result = new PatronDashboard();
		result.setTotalNumberofProposedPatronages(totalNumberofProposedPatronages);
		result.setTotalNumberofAcceptedPatronages(totalNumberofAcceptedPatronages);
		result.setTotalNumberofDeniedPatronages(totalNumberofDeniedPatronages);
		result.setAverageBudgetOfPatronagesGroupedByStatusAndCurrency(averageBudgetOfPatronagesGroupedByStatusAndCurrency);
		result.setDeviationBudgetOfPatronagesGroupedByStatusAndCurrency(deviationBudgetOfPatronagesGroupedByStatusAndCurrency);
		result.setMinimunBudgetOfPatronagesGroupedByStatusAndCurrency(minimumBudgetOfPatronagesGroupedByStatusAndCurrency);
		result.setMaximunBudgetOfPatronagesGroupedByStatusAndCurrency(maximumBudgetOfPatronagesGroupedByStatusAndCurrency);
		
		return result;
	}
	
	private Map<Pair<Status,String>, Double> getStatisticMapByList(final List<String> statisticList) {
		final Map<Pair<Status,String>, Double> result;
		
		result = new HashMap<>();
		for(final String entry: statisticList) {
			// entry -> status,currency,value
			final String[] splitEntry = entry.split(",");
			Status status;
			String currency;
			Double value;
			Pair<Status,String> key;
			
			status = Status.valueOf(splitEntry[0].trim().toUpperCase());
			currency = splitEntry[1].trim();
			value = Double.valueOf(splitEntry[2].trim());
			key = Pair.of(status, currency);
			
			result.put(key, value);
		}
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		List<String> statusList;
		List<String> acceptedCurrencies;
		
		statusList = new ArrayList<>();
		for(final Status s: Status.values()) {
			statusList.add(s.toString().toLowerCase());
		}
		
		acceptedCurrencies = new ArrayList<>();
		for(final String currency: this.repository.acceptedCurrencies().split(",")) {
			acceptedCurrencies.add(currency.trim());
		}
		
		request.unbind(entity, model,
			"totalNumberofProposedPatronages", "totalNumberofAcceptedPatronages", "totalNumberofDeniedPatronages",
			"averageBudgetOfPatronagesGroupedByStatusAndCurrency", "deviationBudgetOfPatronagesGroupedByStatusAndCurrency",
			"minimunBudgetOfPatronagesGroupedByStatusAndCurrency", "maximunBudgetOfPatronagesGroupedByStatusAndCurrency");
		model.setAttribute("statusList", Status.values());
		model.setAttribute("acceptedCurrencies", acceptedCurrencies);
	}

}
