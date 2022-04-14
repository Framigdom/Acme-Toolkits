package acme.features.authenticated.configData;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.configData.ConfigData;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

public class AuthenticatedConfigDataController  extends AbstractController<Authenticated, ConfigData> {


	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedConfigDataListService	listService;

	@Autowired
	protected AuthenticatedConfigDataShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}

}
