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

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdministratorDashboard extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int						totalNumberOfComponents;

	@Transient
	Map<Pair<String,String>,Money>			averageRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	@Transient
	Map<Pair<String,String>,Money>			deviationRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	@Transient
	Map<Pair<String,String>,Money>			minimunRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	@Transient
	Map<Pair<String,String>,Money>			maximumRetailPriceOfComponentsGroupedByTechnologyAndCurrency;
	
	int										totalNumberOfTools;
	
	@Transient
	Map<String,Money>						averageRetailPriceOfToolsGroupedByCurrency;
	@Transient
	Map<String,Money>						deviationRetailPriceOfToolsGroupedByCurrency;
	@Transient
	Map<String,Money>						minimunRetailPriceOfToolsGroupedByCurrency;
	@Transient
	Map<String,Money>						maximumRetailPriceOfToolsGroupedByCurrency;
	
	@Transient
	Map<Status,Integer>						totalNumberOfPatronagesGroupedByStatus;
	
	@Transient
	Map<Status,Money>						averageBudgetOfPatronagesGroupedByStatus;
	@Transient
	Map<Status,Money>						deviationBudgetOfPatronagesGroupedByStatus;
	@Transient
	Map<Status,Money>						minimunBudgetOfPatronagesGroupedByStatus;
	@Transient
	Map<Status,Money>						maximumBudgetOfPatronagesGroupedByStatus;
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
