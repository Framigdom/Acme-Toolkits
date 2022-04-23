package acme.features.administrator.configData;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configData.ConfigData;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorConfigDataRepository extends AbstractRepository {

	@Query("select a from ConfigData a")
	ConfigData findConfigData();
}
