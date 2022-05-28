package acme.features.patron.patronage;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository {
	
	@Query("select patronage from Patronage patronage where patronage.patron.id = :id")
	Collection<Patronage> findPatrongeByPatronId(int id);
	
	@Query("select patronage from Patronage patronage where patronage.id = :id")
	Patronage findPatronageById(int id);
	
	@Query("select patron from Patron patron where patron.id = :id")
	Patron findPatronById(int id);
	
	@Query("select inventor from Inventor inventor")
	List<Inventor> findAllInventors();
	
	@Query("select inventor from Inventor inventor where inventor.userAccount.username = :username")
	Inventor findInventorByUsername(String username);
	
	@Query("select cd.acceptedCurrencies from ConfigData cd")
	String acceptedCurrencies();
	
	@Query("select patronage from Patronage patronage where patronage.code = :code")
	Patronage findPatronageByCode(String code);
	
	@Query("select pr from PatronageReport pr where pr.patronage.id = :id")
	Collection<PatronageReport> findReportsByPatronageId(int id);
}
