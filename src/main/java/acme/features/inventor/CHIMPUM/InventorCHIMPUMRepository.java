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
	
	@Query("SELECT q.artifact FROM Quantity q WHERE q.artifact.chimpum.id =:id")
	Collection<Artifact> findToolsAndComponentsByCHIMPUMId(int id);

	
	@Query("select config.strongSpamTerms from ConfigData config")
	String findStrongSpamTerms();
	
	@Query("select config.weakSpamTerms from ConfigData config")
	String findWeakSpamTerms();
	
	@Query("select config.strongSpamTreshold from ConfigData config")
	int findStrongSpamTreshold();
	
	@Query("select config.weakSpamTreshold from ConfigData config")
	int findWeakSpamTreshold();
	
	@Query("select cd.acceptedCurrencies from ConfigData cd")
	String acceptedCurrencies();
	
	

	/*
	@Query("select a.chimpum from ARTIFACT a where a.id = :id")
	CHIMPUM findCHIMPUMByArtifactId(int id);
	*/

}
