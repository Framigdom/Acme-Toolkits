package acme.features.administrator.announcement;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcements.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorAnnouncementRepository extends AbstractRepository {

	@Query("select a from Announcement a where a.moment > :deadline")
	Collection<Announcement> findRecentAnnouncement(Date deadline);
	
	@Query("select a from Announcement a where a.id = :id")
	Announcement findOneAnnouncementById(int id);
	
	@Query("select config.strongSpamTerms from ConfigData config")
	String findStrongSpamTerms();
	
	@Query("select config.weakSpamTerms from ConfigData config")
	String findWeakSpamTerms();
	
	@Query("select config.strongSpamTreshold from ConfigData config")
	int findStrongSpamTreshold();
	
	@Query("select config.weakSpamTreshold from ConfigData config")
	int findWeakSpamTreshold();
}
