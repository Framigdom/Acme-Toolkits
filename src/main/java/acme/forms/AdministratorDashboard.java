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

import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int						totalNumberOfComponents;

	Map<Pair<String,String>,Double>			averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	Map<Pair<String,String>,Double>			deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	Map<Pair<String,String>,Double>			minimumRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	Map<Pair<String,String>,Double>			maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	
	
	int										totalNumberOfTools;
	
	Map<String,Double>						averageRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>						deviationRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>						minimumRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>						maximumRetailPriceOfToolsGroupedByCurrency;
	
	
	Map<Status,Integer>						totalNumberOfPatronagesGroupedByStatus;
	
	Map<Status,Double>						averageBudgetOfPatronagesGroupedByStatus;
	Map<Status,Double>						deviationBudgetOfPatronagesGroupedByStatus;
	Map<Status,Double>						minimumBudgetOfPatronagesGroupedByStatus;
	Map<Status,Double>						maximumBudgetOfPatronagesGroupedByStatus;
	
	int						ratioOfARTIFACTSWithCHIMPUMP;

	Map<String,Double>			averageBudgetOfCHIMPUMPSGroupedByCurrency;
	Map<String,Double>			deviationBudgetOfCHIMPUMPSGroupedByCurrency;
	Map<String,Double>			minimumBudgetOfCHIMPUMPSGroupedByCurrency;
	Map<String,Double>			maximumBudgetOfCHIMPUMPSGroupedByCurrency;
	
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
