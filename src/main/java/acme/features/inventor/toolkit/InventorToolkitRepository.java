package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Toolkit;
import acme.framework.datatypes.Money;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{

	@Query("SELECT q.toolkit FROM Quantity q WHERE q.artifact.inventor.id = :id GROUP BY q.toolkit")
	Collection<Toolkit> findToolkitsByInventorId(int id);
	
	@Query("SELECT SUM(q.artifact.retailPrice.amount * q.amount) FROM Quantity q WHERE q.toolkit.id = :id")
	Double findToolkitPrice(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findToolkitById(int id);
	
}
