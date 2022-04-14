package acme.features.any.userAccount;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Administrator;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyUserAccountListService implements AbstractListService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected 	AnyUserAccountRepository repository;

	// AbstractListService<Administrator, Announcement> interface --------------


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;
	
		final String roleString = request.getModel().getString("role"); 
		
			
		final Collection<UserAccount> accounts = this.repository.findAccounts();
		
		final List<UserAccount> result = accounts.stream()
			.filter(account -> !account.isAnonymous() && !account.hasRole(Administrator.class))
			.filter(account -> account.getRoles().stream()
				.anyMatch(role -> role.getAuthorityName()
					.equalsIgnoreCase(roleString)))
			.collect(Collectors.toList());
		
		return result;
	
			
	}
	
	
	
	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "identity.name", "identity.surname", "identity.email");
	}

}
