package acme.features.inventor.quantity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Quantity;
import acme.entities.artifacts.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorQuantityRepository extends AbstractRepository{

	@Query("SELECT a FROM Artifact a WHERE a.published = true")
	List<Artifact> findPublishedArtifacts();
	
	@Query("SELECT a FROM Artifact a WHERE a.published = false AND a.inventor = :id")
	List<Artifact> findNonPublishedArtifactsByInventorId(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findToolkitById(int id);

	@Query("SELECT q FROM Quantity q WHERE q.id = :id")
	Quantity findQuantityById(int id);

	@Query("SELECT q FROM Quantity q WHERE q.toolkit.id = :id")
	Collection<Quantity> findQuantitiesByToolkitId(int id);

	@Query("SELECT q.artifact FROM Quantity q WHERE q.id = :id")
	Artifact findArtifactByQuantityId(int id);

	@Query("SELECT a FROM Artifact a WHERE a.name = :artifactName")
	Artifact findArtifactByName(String artifactName);

	@Query("SELECT q.toolkit FROM Quantity q WHERE q.id = :id")
	Toolkit findToolkitByQuantityId(int id);
	
	@Query("SELECT a FROM Artifact a WHERE a.id = :id")
	Artifact findArtifactById(int id);
}
