package acme.features.inventor.patron;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;
import acme.roles.Patron;

@Controller
public class InventorPatronController extends AbstractController<Inventor, Patron>{

	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorPatronShowService showService;

	// Constructors ---------------------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
	}
}