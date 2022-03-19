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

package acme.entities.dashboards;

import java.util.Map;

import javax.persistence.Entity;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class PatronDashboard extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int						totalNumberofProposedPatronages;
	int						totalNumberofAceptedPatronages;
	int						totalNumberofDeniedPatronages;
	
	
	Map<Pair<Status,String>,Money>			averageBudgetOfPatronagesGroupedByStatusAndCurrency;
	Map<Pair<Status,String>,Money>			deviationBudgetOfPatronagesGroupedByStatusAndCurrency;
	Map<Pair<Status,String>,Money>			minimunBudgetOfPatronagesGroupedByStatusAndCurrency;
	Map<Pair<Status,String>,Money>			maximunBudgetOfPatronagesGroupedByStatusAndCurrency;
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
