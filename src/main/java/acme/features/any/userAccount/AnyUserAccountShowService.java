package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Administrator;
import acme.framework.roles.Anonymous;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractShowService;

@Service
public class AnyUserAccountShowService implements AbstractShowService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyUserAccountRepository repository;


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		final UserAccount result = this.repository.findOneUserAccountById(id);
		
		if (result.hasRole(Administrator.class)) {
			return false;
		}
		
		return true;
	}

	@Override
	public UserAccount findOne(final Request<UserAccount> request) {
		assert request != null;

		UserAccount result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneUserAccountById(id);
		result.getRoles().forEach(r -> {
		});

		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		StringBuilder buffer;
		Collection<UserRole> roles;

		request.unbind(entity, model, "username", "identity.name", "identity.surname", "identity.email");

		roles = entity.getRoles();
		buffer = new StringBuilder();
		for (final UserRole role : roles) {
			buffer.append(role.getAuthorityName());
			buffer.append(" ");
		}

		model.setAttribute("roleList", buffer.toString());


		if (entity.hasRole(Administrator.class) || entity.hasRole(Anonymous.class)) {
			model.setAttribute("canUpdate", false);
		} else {
			model.setAttribute("canUpdate", true);
		}
	}
	
}
