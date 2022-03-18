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

package acme.entities.dashboards;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdministratorDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int						totalNumberOfComponents;
	
	Map<String,Double>			averageRetailPriceOfComponentsGroupedByTechnology;
	Map<String,Double>			deviationRetailPriceOfComponentsGroupedByTechnology;
	Map<String,Double>			minimunRetailPriceOfComponentsGroupedByTechnology;
	Map<String,Double>			maximumRetailPriceOfComponentsGroupedByTechnology;

	Map<String,Double>			averageRetailPriceOfComponentsGroupedByCurrency;
	Map<String,Double>			deviationRetailPriceOfComponentsGroupedByCurrency;
	Map<String,Double>			minimunRetailPriceOfComponentsGroupedByCurrency;
	Map<String,Double>			maximumRetailPriceOfComponentsGroupedByCurrency;
	
	int						totalNumberOfTools;
	
	Map<String,Double>			averageRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>			deviationRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>			minimunRetailPriceOfToolsGroupedByCurrency;
	Map<String,Double>			maximumRetailPriceOfToolsGroupedByCurrency;
	
	
	int			totalNumberOfProposedPatronages;
	
	double			averageBudgetOfProposedPatronages;
	double			deviationBudgetOfProposedPatronages;
	double			minimunBudgetOfProposedPatronages;
	double			maximumBudgetOfProposedPatronages;
	
	
	int			totalNumberOfAcceptedPatronages;
	
	double			averageBudgetOfAcceptedPatronages;
	double			deviationBudgetOfAcceptedPatronages;
	double			minimunBudgetOfAcceptedPatronages;
	double			maximumBudgetOfAcceptedPatronages;
	
	
	int			totalNumberOfDeniedPatronages;
	
	double			averageBudgetOfDeniedPatronages;
	double			deviationBudgetOfDeniedPatronages;
	double			minimunBudgetOfDeniedPatronages;
	double			maximumBudgetOfDeniedPatronages;


	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
