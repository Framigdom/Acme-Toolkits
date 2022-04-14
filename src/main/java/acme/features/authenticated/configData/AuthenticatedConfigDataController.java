package acme.features.authenticated.configData;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.configData.ConfigData;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedConfigDataController  extends AbstractController<Authenticated, ConfigData> {


	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedConfigDataShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
	}

}
