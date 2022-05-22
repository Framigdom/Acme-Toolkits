package acme.features.inventor.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.ArtifactType;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorArtifactCreateService implements AbstractCreateService<Inventor, Artifact>{

	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorArtifactRepository repository;

	// AbstractCreateService<Inventor, Artifact> interface ---------------------------
	
	
	@Override
	public boolean authorise(final Request<Artifact> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<Artifact> request, final Artifact entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String type;
		type = request.getModel().getString("type").toUpperCase();
		entity.setArtifactType(ArtifactType.valueOf(type));
		request.bind(entity, errors, "name", "code", "technology" , "description" , "retailPrice", "link");
		
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		String type;
		
		type = request.getModel().getString("type").toUpperCase();
		entity.setArtifactType(ArtifactType.valueOf(type));
		model.setAttribute("type", type);
		request.unbind(entity, model,"name", "code", "technology" , "description" , "retailPrice", "published", "link");
	
		
	}

	@Override
	public Artifact instantiate(final Request<Artifact> request) {
		assert request != null;
		
		Artifact result;
		Inventor inventor;		
		
		inventor = this.repository.findOneInventorById(request.getPrincipal().getActiveRoleId());
		result = new Artifact();
		result.setPublished(false);
		result.setInventor(inventor);
		

		return result;
	}

	@Override
	public void validate(final Request<Artifact> request, final Artifact entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("code")) {
			Artifact exists;
			
			exists = this.repository.findOneArtifactByCode(entity.getCode());
			errors.state(request, exists== null, "code", "inventor.artifact.form.error.duplicated");
		}
		
		if (!errors.hasErrors("retailPrice")) {
			final String currency = entity.getRetailPrice().getCurrency();
			final String currencyAvaliable = this.repository.acceptedCurrencies();
			errors.state(request, entity.getRetailPrice().getAmount() > 0 , "retailPrice", "inventor.artifact.form.error.negative-retailPrice");
			errors.state(request,currencyAvaliable.contains(currency), "retailPrice", "inventor.artifact.form.error.negative-currency");
		}
		
		
	}

	@Override
	public void create(final Request<Artifact> request, final Artifact entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}

}
