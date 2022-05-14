package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Quantity;
import acme.entities.artifacts.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{

	@Query("SELECT t FROM Toolkit t WHERE t.inventor.id = :id")
	Collection<Toolkit> findToolkitsByInventorId(int id);
	
	@Query("SELECT SUM(q.artifact.retailPrice.amount * q.amount) FROM Quantity q WHERE q.toolkit.id = :id")
	Double findToolkitPrice(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findToolkitById(int id);
	
	@Query("SELECT t.inventor FROM Toolkit t WHERE t.id = :id")
	Inventor findInventorByToolkitId(int id);
	
	@Query("SELECT inventor.id FROM Inventor inventor")
	Collection<Integer> findAllInventorId();
	
	@Query("SELECT inventor FROM Inventor inventor WHERE inventor.id = :id")
	Inventor findInventorById(int id);
	
	@Modifying
	@Query("DELETE FROM Quantity q WHERE q.toolkit.id = :id")
	void deleteQuantityByToolkitId(int id);
	
	@Query("SELECT q.artifact FROM Quantity q WHERE q.artifact.inventor.id = :id GROUP BY q.artifact")
	List<Artifact> findArtifactsByInventorId(int id);
	
	@Query("SELECT a FROM Artifact a WHERE a.name = :name")
	Artifact findArtifactByName(String name);

	@Query("SELECT q FROM Quantity q WHERE q.toolkit.id = :id")
	List<Quantity> findQuantitiesByToolkitId(int id);
	
	
	
}
