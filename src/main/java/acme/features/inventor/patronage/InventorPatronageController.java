package acme.features.inventor.patronage;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronage.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorPatronageController extends AbstractController<Inventor, Patronage>{

	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorPatronageListService listService;

	@Autowired
	protected InventorPatronageShowService showService;
	
	@Autowired
	protected InventorPatronageUpdateStatusService updateStatusService;

	// Constructors ---------------------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("update-status", "update", this.updateStatusService);
	}
}