package acme.features.any.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyArtifactRepository extends AbstractRepository {
	
	@Query("select a from Artifact a where a.artifactType = 1 ")
	Collection<Artifact> findAllComponentsByAny();
	
	@Query("select a from Artifact a where a.id=:id")
	Artifact findOneAnyArtifactById(int id);
	
	@Query("select a from Artifact a where a.artifactType = 0 ")
	Collection<Artifact> findAllToolsByAny();
}
