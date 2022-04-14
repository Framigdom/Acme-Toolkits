package acme.features.authenticated.configData;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configData.ConfigData;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedConfigDataRepository extends AbstractRepository {

	
	@Query("select a from ConfigData a where a.id = :id")
	ConfigData findOneConfigDataById(int id);
	
	@Query("select a from ConfigData a")
	Collection<ConfigData> findAllConfigDatas();

}



