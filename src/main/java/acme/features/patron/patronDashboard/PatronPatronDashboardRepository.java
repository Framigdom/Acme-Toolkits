package acme.features.patron.patronDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronDashboardRepository extends AbstractRepository {
	
	@Query("select count(p) from Patronage p where p.patron.id = :patronId and p.status = 0")
	int totalNumberofProposedPatronages(int patronId);
	
	@Query("select count(p) from Patronage p where p.patron.id = :patronId and p.status = 1")
	int totalNumberofAcceptedPatronages(int patronId);
	
	@Query("select count(p) from Patronage p where p.patron.id = :patronId and p.status = 2")
	int totalNumberofDeniedPatronages(int patronId);
	
	@Query("select p.status, p.budget.currency, avg(p.budget.amount) from Patronage p where p.patron.id = :patronId group by p.status, p.budget.currency")
	List<String> averageBudgetOfPatronagesGroupedByStatusAndCurrency(int patronId);
	
	@Query("select p.status, p.budget.currency, stddev(p.budget.amount) from Patronage p where p.patron.id = :patronId group by p.status, p.budget.currency")
	List<String> deviationBudgetOfPatronagesGroupedByStatusAndCurrency(int patronId);
	
	@Query("select p.status, p.budget.currency, min(p.budget.amount) from Patronage p where p.patron.id = :patronId group by p.status, p.budget.currency")
	List<String> minimunBudgetOfPatronagesGroupedByStatusAndCurrency(int patronId);
	
	@Query("select p.status, p.budget.currency, max(p.budget.amount) from Patronage p where p.patron.id = :patronId group by p.status, p.budget.currency")
	List<String> maximunBudgetOfPatronagesGroupedByStatusAndCurrency(int patronId);
	
	@Query("select cd.acceptedCurrencies from ConfigData cd")
	String acceptedCurrencies();
}
