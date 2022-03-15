/*
 * AdministratorDashboard.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.forms;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Integer						totalNumberOfComponents;
	
	Map<String,Double>			averageRetailPriceOfComponentsGroupedByTechnology;
	Map<String,Double>			deviationRetailPriceOfComponentsGroupedByTechnology;
	Map<String,Double>			minimunRetailPriceOfComponentsGroupedByTechnology;
	Map<String,Double>			maximumRetailPriceOfComponentsGroupedByTechnology;

	Map<String,Double>			averageRetailPriceOfComponentsGroupedByCurrency;
	Map<String,Double>			deviationRetailPriceOfComponentsGroupedByCurrency;
	Map<String,Double>			minimunRetailPriceOfComponentsGroupedByCurrency;
	Map<String,Double>			maximumRetailPriceOfComponentsGroupedByCurrency;
	
	Integer						totalNumberOfTools;
	
	Map<String,Double>			averageRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>			deviationRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>			minimunRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>			maximumRetailPriceOfToolsGroupedByCurrency;
	
	
	Integer			totalNumberOfProposedPatronages;
	
	Double			averageBudgetOfProposedPatronages;
	Double			deviationBudgetOfProposedPatronages;
	Double			minimunBudgetOfProposedPatronages;
	Double			maximumBudgetOfProposedPatronages;
	
	
	Integer			totalNumberOfAcceptedPatronages;
	
	Double			averageBudgetOfAcceptedPatronages;
	Double			deviationBudgetOfAcceptedPatronages;
	Double			minimunBudgetOfAcceptedPatronages;
	Double			maximumBudgetOfAcceptedPatronages;
	
	
	Integer			totalNumberOfDeniedPatronages;
	
	Double			averageBudgetOfDeniedPatronages;
	Double			deviationBudgetOfDeniedPatronages;
	Double			minimunBudgetOfDeniedPatronages;
	Double			maximumBudgetOfDeniedPatronages;


	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
