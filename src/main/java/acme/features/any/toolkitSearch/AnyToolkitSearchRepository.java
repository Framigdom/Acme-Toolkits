package acme.features.any.toolkitSearch;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitSearchRepository extends AbstractRepository {

	@Query("select a from Artifact a where a.name=:name")
	Artifact findArtifactByName(String name);
	
	@Query("select q.toolkit from Quantity q where q.artifact.id=:id")
	List<Toolkit> findToolkitByArtifactId(int id);
	
	@Query("select a.name from Artifact a where a.published=true")
	List<String> findAllArtifact();
}
