package acme.features.inventor.quantity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.artifacts.Quantity;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorQuantityController extends AbstractController<Inventor, Quantity>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorQuantityListService listService;	
	
	@Autowired
	protected InventorQuantityShowService showService;
	
	@Autowired
	protected InventorQuantityCreateService createService;
	
	@Autowired
	protected InventorQuantityDeleteService deleteService;
	
	@Autowired
	protected InventorQuantityUpdateService updateService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("update", this.updateService);
	}
	
}
