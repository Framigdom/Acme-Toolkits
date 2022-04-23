package acme.features.any.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Quantity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyArtifactRepository extends AbstractRepository {
	
	@Query("select a from Artifact a where a.artifactType = 1 and a.published=true")
	Collection<Artifact> findAllComponentsPublished();
	
	@Query("select a from Artifact a where a.id=:id")
	Artifact findOneAnyArtifactById(int id);
	
	@Query("select a from Artifact a where a.artifactType = 0 and a.published=true")
	Collection<Artifact> findAllToolsPublished();
	
	@Query("SELECT q FROM Quantity q WHERE q.artifact.id =:id")
	Quantity findQuantityByArtifactId(int id);
	
	@Query("SELECT q.artifact FROM Quantity q WHERE q.toolkit.id =:id and q.artifact.published=true")
	Collection<Artifact> findToolsAndComponentsByToolkitId(int id);
}
