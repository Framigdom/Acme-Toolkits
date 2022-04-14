package acme.features.authenticated.configData;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.configData.ConfigData;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService;

public class AuthenticatedConfigDataListService implements AbstractListService<Authenticated, ConfigData> {


	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedConfigDataRepository repository;

	// AbstractListService<Authenticated, ConfigData> interface --------------


	@Override
	public boolean authorise(final Request<ConfigData> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<ConfigData> findMany(final Request<ConfigData> request) {
		assert request != null;

		Collection<ConfigData> result;

		result = this.repository.findAllConfigDatas();

		return result;
	}

	@Override
	public void unbind(final Request<ConfigData> request, final ConfigData entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "systemCurrency", "acceptedCurrencies");
	}
	
	
}
