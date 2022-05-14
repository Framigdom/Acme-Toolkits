package acme.features.any.chirp;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chirps.Chirp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyChirpRepository extends AbstractRepository {

	@Query("select c from Chirp c where c.moment > :deadline")
	Collection<Chirp> findRecentChirp(Date deadline);
	
	@Query("select config.strongSpamTerms from ConfigData config")
	String findStrongSpamTerms();
	
	@Query("select config.weakSpamTerms from ConfigData config")
	String findWeakSpamTerms();
	
	@Query("select config.strongSpamTreshold from ConfigData config")
	int findStrongSpamTreshold();
	
	@Query("select config.weakSpamTreshold from ConfigData config")
	int findWeakSpamTreshold();
}
