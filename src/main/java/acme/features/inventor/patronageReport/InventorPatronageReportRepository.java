package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("select pr from PatronageReport pr where pr.patronage.id = :id")
	Collection<PatronageReport> findPatronageReportByPatronageId(int id);

	@Query("select pr from PatronageReport pr where pr.id = :id")
	PatronageReport findPatronageReportById(int id);
	
	@Query("select p from Patronage p where p.id = :id")
	Patronage findPatronageById(int id);
}