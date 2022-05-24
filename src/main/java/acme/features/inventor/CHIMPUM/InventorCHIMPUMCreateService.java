package acme.features.inventor.CHIMPUM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import features.SpamDetector;

@Service
public class InventorCHIMPUMCreateService  implements AbstractCreateService<Inventor,CHIMPUM>{	
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorCHIMPUMRepository repository;
	
	// AbstractListService<Inventor, CHIMPUM> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "pattern", "moment", "title", "description", "startDate","finishDate","budget","link");
		
	}

	@Override
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
				
		request.unbind(entity, model, "pattern", "moment", "title", "description", "startDate","finishDate","budget","link");
		
		
	}

	@Override
	public CHIMPUM instantiate(final Request<CHIMPUM> request) {
		assert request != null;

		CHIMPUM result;
		result = new CHIMPUM();

		return result;
	}

	@Override
	public void validate(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
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
		
		if(!errors.hasErrors("title")) {
			errors.state(request, !spamDetector.containsSpam(weakSpamTerms.split(","), weakSpamThreshold, entity.getTitle())
				&& !spamDetector.containsSpam(strongSpamTerms.split(","), strongSpamThreshold, entity.getTitle()),
				"title", "inventor.CHIMPUM.form.error.spam");
		}
		
		if(!errors.hasErrors("description")) {
			errors.state(request, !spamDetector.containsSpam(weakSpamTerms.split(","), weakSpamThreshold, entity.getDescription())
				&& !spamDetector.containsSpam(strongSpamTerms.split(","), strongSpamThreshold, entity.getDescription()),
				"description", "inventor.CHIMPUM.form.error.spam");
		}
		
		
	}

	@Override
	public void create(final Request<CHIMPUM> request, final CHIMPUM entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	
	}



}
