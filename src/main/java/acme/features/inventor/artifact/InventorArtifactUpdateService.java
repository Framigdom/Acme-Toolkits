package acme.features.inventor.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;
import features.SpamDetector;

@Service
public class InventorArtifactUpdateService implements AbstractUpdateService<Inventor, Artifact> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorArtifactRepository repository;
	
	// AbstractUpdateService<Inventor, Artifact> interface ---------------------------
	
	
	@Override
	public boolean authorise(final Request<Artifact> request) {
		assert request != null;
		
		boolean result;
		int artifactId;
		Artifact artifact;
		Inventor inventor;

		artifactId = request.getModel().getInteger("id");
		artifact = this.repository.findArtifactById(artifactId);
		inventor = artifact.getInventor();
		result = request.isPrincipal(inventor);

		return result;
	}

	@Override
	public void bind(final Request<Artifact> request, final Artifact entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "name", "code", "technology" , "description" , "retailPrice", "artifactType", "link");
		
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model,"name", "code", "technology" , "description" , "retailPrice", "artifactType", "published", "link");

		
	}

	@Override
	public Artifact findOne(final Request<Artifact> request) {
		assert request != null;

		Artifact result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findArtifactById(id);

		return result;
	}

	@Override
	public void validate(final Request<Artifact> request, final Artifact entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		SpamDetector spamDetector;
		String strongSpamTerms;
		String weakSpamTerms;
		int strongSpamThreshold;
		int weakSpamThreshold;
		
		spamDetector = new SpamDetector();
		strongSpamTerms = this.repository.findStrongSpamTerms();
		weakSpamTerms = this.repository.findWeakSpamTerms();
		strongSpamThreshold = this.repository.findStrongSpamTreshold();
		weakSpamThreshold = this.repository.findWeakSpamTreshold();
		
		if(!errors.hasErrors("code")) {
			Artifact exists;
			
			exists = this.repository.findOneArtifactByCode(entity.getCode());
			errors.state(request, exists== null || exists.equals(entity), "code", "inventor.artifact.form.error.duplicated");
		}
		
		if (!errors.hasErrors("retailPrice")) {
			final String currency = entity.getRetailPrice().getCurrency();
			final String currencyAvaliable = this.repository.acceptedCurrencies();
			boolean acceptedCurrency = false;
			
			for(final String cur: currencyAvaliable.split(",")) {
				acceptedCurrency = cur.trim().equalsIgnoreCase(currency);
				if(acceptedCurrency)
					break;
			}
			errors.state(request, entity.getRetailPrice().getAmount() > 0 , "retailPrice", "inventor.artifact.form.error.negative-retailPrice");
			errors.state(request,acceptedCurrency, "retailPrice", "inventor.artifact.form.error.negative-currency");
		}
		
		if (!errors.hasErrors("name")) {
			errors.state(request, !spamDetector.containsSpam(weakSpamTerms.split(","), weakSpamThreshold, entity.getName())
				&& !spamDetector.containsSpam(strongSpamTerms.split(","), strongSpamThreshold, entity.getName()),
				"name", "inventor.artifact.form.error.spam");
		}
		
		if (!errors.hasErrors("technology")) {
			errors.state(request, !spamDetector.containsSpam(weakSpamTerms.split(","), weakSpamThreshold, entity.getTechnology())
				&& !spamDetector.containsSpam(strongSpamTerms.split(","), strongSpamThreshold, entity.getTechnology()),
				"technology", "inventor.artifact.form.error.spam");
		}
		
		if (!errors.hasErrors("description")) {
			errors.state(request, !spamDetector.containsSpam(weakSpamTerms.split(","), weakSpamThreshold, entity.getDescription())
				&& !spamDetector.containsSpam(strongSpamTerms.split(","), strongSpamThreshold, entity.getDescription()),
				"description", "inventor.artifact.form.error.spam");
		}
		
	}

	@Override
	public void update(final Request<Artifact> request, final Artifact entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}
	

}
