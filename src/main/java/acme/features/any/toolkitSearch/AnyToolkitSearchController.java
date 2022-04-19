package acme.features.any.toolkitSearch;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.forms.ToolkitSearch;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyToolkitSearchController extends AbstractController<Any, ToolkitSearch> {

    // Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolkitSearchPerformService performService;
	
	
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("perform", this.performService);
	}
}
