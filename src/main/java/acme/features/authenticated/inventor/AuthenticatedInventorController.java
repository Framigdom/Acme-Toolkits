
package acme.features.authenticated.inventor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;
import acme.roles.Inventor;

@Controller
//@RequestMapping("/authenticated/Inventor/")
public class AuthenticatedInventorController extends AbstractController<Authenticated, Inventor> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedInventorCreateService	createService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("create", this.createService);
	}

}
