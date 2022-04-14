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
	protected InventorArtifactShowService showService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-mine", "list", listMineService);
		super.addCommand("show", showService);
	}
	
}
