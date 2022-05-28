package acme.features.inventor.artifact;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Quantity;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorArtifactRepository extends AbstractRepository{

	
	@Query("select c from CHIMPUM c")
	List<CHIMPUM> findAllCHIMPUM();
	
	@Query("SELECT c from CHIMPUM c where c.pattern = :pattern")
	CHIMPUM findCHIMPUMByPattern(String pattern);
	
	@Query("SELECT a FROM Artifact a WHERE a.inventor.id = :id AND a.artifactType = 0")
	Collection<Artifact> findToolsByInventorId(int id);
	
	@Query("SELECT a FROM Artifact a WHERE a.inventor.id = :id AND a.artifactType = 1")
	Collection<Artifact> findComponentsByInventorId(int id);
	
	@Query("SELECT q.artifact FROM Quantity q WHERE q.toolkit.id =:id")
	Collection<Artifact> findToolsAndComponentsByToolkitId(int id);
	
	@Query("SELECT q.artifact FROM Quantity q WHERE q.artifact.chimpum.id =:id and q.artifact.published=true")
	Collection<Artifact> findToolsAndComponentsByCHIMPUMId(int id);
	
	@Query("SELECT a FROM Artifact a WHERE a.id = :id")
	Artifact findArtifactById(int id);
	
	@Query("SELECT q FROM Quantity q WHERE q.artifact.id =:id")
	Quantity findQuantityByArtifactId(int id);
	

	@Query("SELECT inventor.id FROM Inventor inventor")
	Collection<Integer> findAllInventorId();
	
	@Query("SELECT i FROM Inventor i where i.id = :id")
	Inventor findOneInventorById(int id);
	
	@Query("SELECT a from Artifact a where a.code = :code")
	Artifact findOneArtifactByCode(String code);
	
	@Query("select cd.acceptedCurrencies from ConfigData cd")
	String acceptedCurrencies();
	
	@Query("select config.strongSpamTerms from ConfigData config")
	String findStrongSpamTerms();
	
	@Query("select config.weakSpamTerms from ConfigData config")
	String findWeakSpamTerms();
	
	@Query("select config.strongSpamTreshold from ConfigData config")
	int findStrongSpamTreshold();
	
	@Query("select config.weakSpamTreshold from ConfigData config")
	int findWeakSpamTreshold();
}
