package acme.features.inventor.artifact;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.artifacts.Artifact;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorArtifactController extends AbstractController<Inventor, Artifact>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorArtifactListMineService listMineService;
	
	@Autowired
	protected InventorArtifactListByCHIMPUMService listCHIMPUMService;
	
	@Autowired
	protected InventorArtifactListService listService;
	
	@Autowired
	protected InventorArtifactShowService showService;
	
	@Autowired
	protected InventorArtifactCreateService createService;
	
	@Autowired
	protected InventorArtifactPublishService publishService;
	
	@Autowired
	protected InventorArtifactDeleteService deleteService;
	
	@Autowired
	protected InventorArtifactUpdateService updateService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("publish", "update", this.publishService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);
		
		super.addCommand("list", this.listService);
		super.addCommand("list-mine", "list", this.listMineService);
		super.addCommand("list-chimpum", "list", this.listCHIMPUMService);
		super.addCommand("show", this.showService);
	}
	
}
