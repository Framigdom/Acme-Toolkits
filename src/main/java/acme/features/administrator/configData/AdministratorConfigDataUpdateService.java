package acme.features.administrator.configData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configData.ConfigData;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorConfigDataUpdateService implements AbstractUpdateService<Administrator, ConfigData> {



	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorConfigDataRepository repository;

	// AbstractUpdateService<Administrator, ConfigData> interface --------------


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

		request.unbind(entity, model, "systemCurrency", "acceptedCurrencies", "strongSpamTerms",
										"weakSpamTerms", "strongSpamTreshold", "weakSpamTreshold");
	}

	@Override
	public void bind(final Request<ConfigData> request, final ConfigData entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "systemCurrency", "acceptedCurrencies", "strongSpamTerms",
			"weakSpamTerms", "strongSpamTreshold", "weakSpamTreshold");
		
	}

	@Override
	public void validate(final Request<ConfigData> request, final ConfigData entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if(!errors.hasErrors("strongSpamTreshold")) {
			errors.state(request, entity.getStrongSpamTreshold()>0 && entity.getStrongSpamTreshold()<=100, "strongSpamTreshold", "administrator.configData.form.error.strongSpamTreshold");
		}

		if(!errors.hasErrors("weakSpamTreshold")) {
			errors.state(request, entity.getWeakSpamTreshold()>0 && entity.getWeakSpamTreshold()<=100, "weakSpamTreshold", "administrator.configData.form.error.weakSpamTreshold");
		}
		
	}

	@Override
	public void update(final Request<ConfigData> request, final ConfigData entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
