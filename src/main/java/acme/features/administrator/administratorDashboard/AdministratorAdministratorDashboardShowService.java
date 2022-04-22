package acme.features.administrator.administratorDashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Status;
import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorAdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard> {

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected AdministratorAdministratorDashboardRepository repository;
	
	// AbstractShowService<Administrator, AdministratorDashboard> interface -----------------
	
	@Override
	public boolean authorise(final Request<AdministratorDashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
		assert request != null;
		
		final AdministratorDashboard result;
		
		final int totalNumberOfComponents;
		final Map<Pair<String,String>,Double> averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
		final Map<Pair<String,String>,Double> deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
		final Map<Pair<String,String>,Double> minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
		final Map<Pair<String,String>,Double> maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
		
		final int totalNumberOfTools;
		final Map<String,Double>	averageRetailPriceOfToolsGroupedByCurrency;
		final Map<String,Double>	deviationRetailPriceOfToolsGroupedByCurrency;
		final Map<String,Double>	minimunRetailPriceOfToolsGroupedByCurrency;
		final Map<String,Double>	maximumRetailPriceOfToolsGroupedByCurrency;
		
		final Map<Status,Integer> 	totalNumberOfPatronagesGroupedByStatus;
		final Map<Status,Double> 	averageBudgetOfPatronagesGroupedByStatus;
		final Map<Status,Double>	deviationBudgetOfPatronagesGroupedByStatus;
		final Map<Status,Double>	minimunBudgetOfPatronagesGroupedByStatus;
		final Map<Status,Double>	maximumBudgetOfPatronagesGroupedByStatus;
		
		
		totalNumberOfComponents = this.repository.totalNumberOfComponents();
		totalNumberOfTools = this.repository.totalNumberOfTools();
		totalNumberOfPatronagesGroupedByStatus = this.totalNumberOfPatronagesGroupedByStatusMap(
			this.repository.totalNumberOfPatronagesGroupedByStatus());
		
		//Components methods
		
		averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency = this.componentsMethodsMap(
			this.repository.averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency());
		deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency = this.componentsMethodsMap(
			this.repository.deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency());
		minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency = this.componentsMethodsMap(
			this.repository.minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency());
		maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency = this.componentsMethodsMap(
			this.repository.maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency());
		
		//Tools methods
		
		averageRetailPriceOfToolsGroupedByCurrency = this.toolsMethodsMap(
			this.repository.averageRetailPriceOfToolsGroupedByCurrency());
		deviationRetailPriceOfToolsGroupedByCurrency = this.toolsMethodsMap(
			this.repository.deviationRetailPriceOfToolsGroupedByCurrency());
		minimunRetailPriceOfToolsGroupedByCurrency = this.toolsMethodsMap(
			this.repository.minimunRetailPriceOfToolsGroupedByCurrency());
		maximumRetailPriceOfToolsGroupedByCurrency = this.toolsMethodsMap(
			this.repository.maximumRetailPriceOfToolsGroupedByCurrency());
		
		//Patronages methods
		
		averageBudgetOfPatronagesGroupedByStatus = this.patronagesMethodsMap(
			this.repository.averageBudgetOfPatronagesGroupedByStatus());
		deviationBudgetOfPatronagesGroupedByStatus = this.patronagesMethodsMap(
			this.repository.deviationBudgetOfPatronagesGroupedByStatus());
		minimunBudgetOfPatronagesGroupedByStatus = this.patronagesMethodsMap(
			this.repository.minimunBudgetOfPatronagesGroupedByStatus());
		maximumBudgetOfPatronagesGroupedByStatus = this.patronagesMethodsMap(
			this.repository.maximumBudgetOfPatronagesGroupedByStatus());
		
		
		result = new AdministratorDashboard();
		
		result.setTotalNumberOfComponents(totalNumberOfComponents);
		result.setTotalNumberOfTools(totalNumberOfTools);
		result.setTotalNumberOfPatronagesGroupedByStatus(totalNumberOfPatronagesGroupedByStatus);
		
		result.setAverageRetailPriceOfComponentsGroupedByTechnologyAndCurrency(averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency);
		result.setDeviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency(deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency);
		result.setMinimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency(minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency);
		result.setMaximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency(maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency);
		
		result.setAverageRetailPriceOfToolsGroupedByCurrency(averageRetailPriceOfToolsGroupedByCurrency);
		result.setDeviationRetailPriceOfToolsGroupedByCurrency(deviationRetailPriceOfToolsGroupedByCurrency);
		result.setMinimunRetailPriceOfToolsGroupedByCurrency(minimunRetailPriceOfToolsGroupedByCurrency);
		result.setMaximumRetailPriceOfToolsGroupedByCurrency(maximumRetailPriceOfToolsGroupedByCurrency);
		
		result.setAverageBudgetOfPatronagesGroupedByStatus(averageBudgetOfPatronagesGroupedByStatus);
		result.setDeviationBudgetOfPatronagesGroupedByStatus(deviationBudgetOfPatronagesGroupedByStatus);
		result.setMinimunBudgetOfPatronagesGroupedByStatus(minimunBudgetOfPatronagesGroupedByStatus);
		result.setMaximumBudgetOfPatronagesGroupedByStatus(maximumBudgetOfPatronagesGroupedByStatus);
		
		return result;
	}
	
	private Map<Pair<String,String>,Double> componentsMethodsMap(final List<String> ls) {
		final Map<Pair<String,String>,Double> result;
		
		result = new HashMap<>();
		for(final String entry: ls) {
			// entry -> technology, currency, amount
			final String[] splitEntry = entry.split(",");
			String technology;
			String currency;
			Double amount;
			Pair<String,String> key;
			
			technology = splitEntry[0].trim();
			currency = splitEntry[1].trim();
			amount = Double.valueOf(splitEntry[2].trim());
			key = Pair.of(technology, currency);
			
			result.put(key, amount);
		}
		
		return result;
	}
	
	private Map<String, Double> toolsMethodsMap(final List<String> ls) {
		final Map<String, Double> result;
		
		result = new HashMap<>();
		for(final String entry: ls) {
			// entry -> currency, amount
			final String[] splitEntry = entry.split(",");
			String currency;
			Double amount;
			String key;
			
			currency = splitEntry[0].trim();
			amount = Double.valueOf(splitEntry[1].trim());
			key = currency;
			
			result.put(key, amount);
		}
		
		return result;
	}
	
	private Map<Status, Double> patronagesMethodsMap(final List<String> ls) {
		final Map<Status, Double> result;
		
		result = new HashMap<>();
		for(final String entry: ls) {
			// entry -> status, amount
			final String[] splitEntry = entry.split(",");
			Status status;
			Double amount;
			Status key;
			
			status = Status.valueOf(splitEntry[0].trim());
			amount = Double.valueOf(splitEntry[1].trim());
			key = status;
			
			result.put(key, amount);
		}
		
		return result;
	}
	
	private Map<Status, Integer> totalNumberOfPatronagesGroupedByStatusMap(final List<String> ls) {
		final Map<Status, Integer> result;
		
		result = new HashMap<>();
		for(final String entry: ls) {
			// entry -> status, count(patronage)
			final String[] splitEntry = entry.split(",");
			Status status;
			Integer totalPatronages;
			Status key;
			
			status = Status.valueOf(splitEntry[0].trim());
			totalPatronages = Integer.valueOf(splitEntry[1].trim());
			key = status;
			
			result.put(key, totalPatronages);
		}
		
		return result;
	}
	

	@Override
	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		List<String> statusList;
		final List<String> technologyList;
		final List<String> acceptedCurrencies;
		
		statusList = new ArrayList<>();
		for(final Status s: Status.values()) {
			statusList.add(s.toString().toLowerCase());
		}
		
		technologyList = new ArrayList<>();
		for(final String s: this.repository.allTechnologies()) {
			technologyList.add(s.toLowerCase());
		}
		
		acceptedCurrencies = new ArrayList<>();
		for(final String currency: this.repository.acceptedCurrencies().split(",")) {
			acceptedCurrencies.add(currency.trim());
		}
		
		request.unbind(entity, model,
				"totalNumberOfComponents",
			"averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency",
			"deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency",
			"minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency",
			"maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency",
				"totalNumberOfTools",
			"averageRetailPriceOfToolsGroupedByCurrency",
			"deviationRetailPriceOfToolsGroupedByCurrency",
			"minimunRetailPriceOfToolsGroupedByCurrency",
			"maximumRetailPriceOfToolsGroupedByCurrency",
				"totalNumberOfPatronagesGroupedByStatus",
			"averageBudgetOfPatronagesGroupedByStatus",
			"deviationBudgetOfPatronagesGroupedByStatus",
			"minimunBudgetOfPatronagesGroupedByStatus",
			"maximumBudgetOfPatronagesGroupedByStatus");
		
		
		model.setAttribute("statusList", Status.values());
		model.setAttribute("technologyList", technologyList);
		model.setAttribute("acceptedCurrencies", acceptedCurrencies);
	}

}
