package acme.features.authenticated.configData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configData.ConfigData;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedConfigDataShowService implements AbstractShowService<Authenticated, ConfigData> {



	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedConfigDataRepository repository;

	// AbstractShowService<Authenticated, ConfigData> interface --------------


	@Override
	public boolean authorise(final Request<ConfigData> request) {
		assert request != null;
			
		return true;
	}

	@Override
	public ConfigData findOne(final Request<ConfigData> request) {
		assert request != null;

		ConfigData result;
		result = this.repository.findConfigData();

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