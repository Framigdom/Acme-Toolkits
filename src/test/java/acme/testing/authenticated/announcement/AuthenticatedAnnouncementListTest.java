package acme.testing.authenticated.announcement;

import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.announcements.Announcement;
import acme.features.authenticated.announcement.AuthenticatedAnnouncementRepository;
import acme.framework.helpers.FactoryHelper;
import acme.testing.TestHarness;

public class AuthenticatedAnnouncementListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	
	@Autowired
	private AuthenticatedAnnouncementRepository repository;
	
	@Override
	@BeforeAll
	public void beforeAll() {
	    super.beforeAll();
	    FactoryHelper.autowire(this);
	    this.patchAnnouncements();
	}
	
	protected void patchAnnouncements() {
	    Collection<Announcement> announcements;
	    Date moment;

	    announcements = this.repository.findAnnouncements();
	    for (final Announcement announcement : announcements) {
	        moment = new Date();
	        announcement.setMoment(moment);
	        this.repository.save(announcement);
	    }
	}
	
	// Test cases -------------------------------------------------------------

	

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final String moment, final String body, final String link, final String critical) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Authenticated", "List announcements");
		super.checkListingExists();
		
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 2, link);
		super.checkColumnHasValue(recordIndex, 3, critical);
				
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("critical", critical);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex, final String title, final String moment, final String body, final String link, final String critical) {
	
		super.navigate("/authenticated/announcement/list");
		super.checkErrorsExist();
		
	}
	
	// Ancillary methods ------------------------------------------------------

}
