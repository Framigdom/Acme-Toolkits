package acme.features.patron.patronDashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.forms.PatronDashboard;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronPatronDashboardController extends AbstractController<Patron, PatronDashboard> {
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected PatronPatronDashboardShowService showService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
	}
}
