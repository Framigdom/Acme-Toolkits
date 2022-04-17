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

import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PatronDashboard {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int						totalNumberofProposedPatronages;
	int						totalNumberofAcceptedPatronages;
	int						totalNumberofDeniedPatronages;
	
	Map<Pair<Status,String>,Double>			averageBudgetOfPatronagesGroupedByStatusAndCurrency;
	Map<Pair<Status,String>,Double>			deviationBudgetOfPatronagesGroupedByStatusAndCurrency;
	Map<Pair<Status,String>,Double>			minimunBudgetOfPatronagesGroupedByStatusAndCurrency;
	Map<Pair<Status,String>,Double>			maximunBudgetOfPatronagesGroupedByStatusAndCurrency;
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
