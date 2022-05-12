package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Quantity;
import acme.entities.artifacts.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitCreateService  implements AbstractCreateService<Inventor,Toolkit>{	
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitRepository repository;
	
	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		final Integer activeId = request.getPrincipal().getActiveRoleId();		
		final Collection<Integer> existingInventors = this.repository.findAllInventorId();		
		return  existingInventors.stream().anyMatch(x -> x == activeId);
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "title", "code", "description", "assemblyNotes", "link");
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		List<Artifact> artifacts;
		artifacts = this.repository.findArtifactsByInventorId(request.getPrincipal().getActiveRoleId());
				
		request.unbind(entity, model, "title", "code", "description", "assemblyNotes", "link","published");
		model.setAttribute("artifacts", artifacts);
		
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		result = new Toolkit();
		result.setPublished(false);

		return result;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
		
		Integer numOfArtifacts;
		numOfArtifacts = this.repository.findArtifactsByInventorId(request.getPrincipal().getActiveRoleId()).size();
	
		for (int i = 1; i < numOfArtifacts+1; i++) {
			  final String iToString = Integer.toString(i);
			  final String artifactName = (String) request.getModel().getAttribute(iToString);
			  if(!artifactName.equals("none")) {
				  final Artifact artifact = this.repository.findArtifactByName(artifactName);
				  final int j = i+100;
				  final String jToString = Integer.toString(j);
				  final String amount = (String) request.getModel().getAttribute(jToString);
				  final Quantity q = new Quantity();
					q.setAmount(Integer. parseInt(amount));
					q.setArtifact(artifact);
					q.setToolkit(entity);
					this.repository.save(q);
			  }

			  

			}


		
	}



}
