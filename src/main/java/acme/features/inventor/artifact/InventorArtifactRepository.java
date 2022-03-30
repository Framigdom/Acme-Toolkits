package acme.features.inventor.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorArtifactRepository extends AbstractRepository{

	@Query("SELECT a FROM Artifact a WHERE a.inventor.id = :id AND a.artifactType = acme.entities.artifacts.ArtifactType.TOOL")
	Collection<Artifact> findToolsByInventorId(int id);
	
	@Query("SELECT a FROM Artifact a WHERE a.inventor.id = :id AND a.artifactType = acme.entities.artifacts.ArtifactType.COMPONENT")
	Collection<Artifact> findComponentsByInventorId(int id);
	

}
