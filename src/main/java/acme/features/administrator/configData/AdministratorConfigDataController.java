package acme.features.administrator.configData;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.configData.ConfigData;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdministratorConfigDataController extends AbstractController<Administrator, ConfigData> {


	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorConfigDataShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
	}

}
