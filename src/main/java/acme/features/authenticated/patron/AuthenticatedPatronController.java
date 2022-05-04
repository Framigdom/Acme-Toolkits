
package acme.features.authenticated.patron;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;
import acme.roles.Patron;

@Controller
//@RequestMapping("/authenticated/Patron/")
public class AuthenticatedPatronController extends AbstractController<Authenticated, Patron> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedPatronCreateService	createService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("create", this.createService);
	}

}
