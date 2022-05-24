package acme.features.inventor.CHIMPUM;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorCHIMPUMListService implements AbstractListService<Inventor, CHIMPUM>{

	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorCHIMPUMRepository repository;

	// AbstractListService<Inventor, Patronage> interface ---------------------------------

	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<CHIMPUM> findMany(final Request<CHIMPUM> request) {
		assert request != null;

		int masterId;
		masterId = request.getModel().getInteger("artifactId");
		
		return this.repository.findCHIMPUMSByArtifactId(masterId);
	}

	@Override
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		//int artifactId = request.getModel().getInteger("artifactId");
		request.unbind(entity, model, "title", "description");
		//model.setAttribute("artifactId", artifactId);
	}

}