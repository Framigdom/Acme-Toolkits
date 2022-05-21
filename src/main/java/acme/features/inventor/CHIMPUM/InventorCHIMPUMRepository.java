package acme.features.inventor.CHIMPUM;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.entities.artifacts.Artifact;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorCHIMPUMRepository extends AbstractRepository{
	

	@Query("select c from CHIMPUM c")
	Collection<CHIMPUM> findAllCHIMPUM();
	
	@Query("select c from CHIMPUM c where c.id = :id")
	CHIMPUM findCHIMPUMById(int id);
	
	@Query("select a from Artifact a where a.id = :id")
	Artifact findARTIFACTById(int id);
	/*
	@Query("select a.chimpum from ARTIFACT a where a.id = :id")
	CHIMPUM findCHIMPUMByArtifactId(int id);
	*/

}
