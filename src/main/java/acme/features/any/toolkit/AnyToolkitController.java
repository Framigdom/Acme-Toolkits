package acme.features.any.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.artifacts.Toolkit;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyToolkitController extends AbstractController<Any, Toolkit>{
	
	    // Internal state ---------------------------------------------------------
	
		@Autowired
		protected AnyToolkitListService listService;
		
		@Autowired
		protected AnyToolkitShowService showService;
		
		
		// Constructors -----------------------------------------------------------
		
		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
		}

}
