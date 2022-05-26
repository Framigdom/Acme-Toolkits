package acme.features.inventor.CHIMPUM;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorCHIMPUMController extends AbstractController<Inventor, CHIMPUM>{
	
	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorCHIMPUMListService listService;

	@Autowired
	protected InventorCHIMPUMShowService showService;
	
	@Autowired
	protected InventorCHIMPUMCreateService createService;
	
	@Autowired
	protected InventorCHIMPUMUpdateService updateService;
	
	@Autowired
	protected InventorCHIMPUMDeleteService deleteService;

	// Constructors ---------------------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);
	}
	

}
