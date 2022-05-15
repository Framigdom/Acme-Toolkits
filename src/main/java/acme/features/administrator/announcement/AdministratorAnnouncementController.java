package acme.features.administrator.announcement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcements.Announcement;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdministratorAnnouncementController extends AbstractController<Administrator, Announcement> {

	// Internal state ---------------------------------------------------------

	
	@Autowired
	protected AdministratorAnnouncementCreateService		createService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("create", this.createService);
	}

}
