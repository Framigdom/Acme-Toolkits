package acme.features.inventor.CHIMPUM;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.entities.artifacts.Artifact;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorCHIMPUMRepository extends AbstractRepository{

	@Query("SELECT c FROM CHIMPUM c WHERE c.artifact.id = :id")
	Collection<CHIMPUM> findCHIMPUMSByArtifactId(int id);

	@Query("SELECT c FROM CHIMPUM c WHERE c.id = :id")
	CHIMPUM findCHIMPUMById(int id);

	@Query("SELECT a FROM Artifact a WHERE a.id = :id")
	Artifact findArtifactById(int id);

}
