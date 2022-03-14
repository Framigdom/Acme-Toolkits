/*
 * PatronDashboard.java
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
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Integer						totalNumberofProposedPatronages;
	Integer						totalNumberofAceptedPatronages;
	Integer						totalNumberofDeniedPatronages;
	
	Map<String,Double>			averageBudgetOfProposedPatronagesGroupedByCurrency;
	Map<String,Double>			deviationBudgetOfProposedPatronagesGroupedByCurrency;
	Map<String,Double>			minimunBudgetOfProposedPatronagesGroupedByCurrency;
	Map<String,Double>			maximunBudgetOfProposedPatronagesGroupedByCurrency;
	
	Map<String,Double>			averageBudgetOfAceptedPatronagesGroupedByCurrency;
	Map<String,Double>			deviationBudgetOfAceptedPatronagesGroupedByCurrency;
	Map<String,Double>			minimunBudgetOfAceptedPatronagesGroupedByCurrency;
	Map<String,Double>			maximunBudgetOfAceptedPatronagesGroupedByCurrency;
	

	Map<String,Double>			averageBudgetOfDeniedPatronagesGroupedByCurrency;
	Map<String,Double>			deviationBudgetOfDeniedPatronagesGroupedByCurrency;
	Map<String,Double>			minimunBudgetOfDeniedPatronagesGroupedByCurrency;
	Map<String,Double>			maximunBudgetOfDeniedPatronagesGroupedByCurrency;


	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
