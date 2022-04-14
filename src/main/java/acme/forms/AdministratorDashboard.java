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
import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int						totalNumberOfComponents;

	Map<Pair<String,String>,Money>			averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	Map<Pair<String,String>,Money>			deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	Map<Pair<String,String>,Money>			minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	Map<Pair<String,String>,Money>			maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	
	int										totalNumberOfTools;
	
	Map<String,Money>						averageRetailPriceOfToolsGroupedByCurrency;
	Map<String,Money>						deviationRetailPriceOfToolsGroupedByCurrency;
	Map<String,Money>						minimunRetailPriceOfToolsGroupedByCurrency;
	Map<String,Money>						maximumRetailPriceOfToolsGroupedByCurrency;
	
	
	Map<Status,Integer>						totalNumberOfPatronagesGroupedByStatus;
	
	Map<Status,Money>						averageBudgetOfPatronagesGroupedByStatus;
	Map<Status,Money>						deviationBudgetOfPatronagesGroupedByStatus;
	Map<Status,Money>						minimunBudgetOfPatronagesGroupedByStatus;
	Map<Status,Money>						maximumBudgetOfPatronagesGroupedByStatus;
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
