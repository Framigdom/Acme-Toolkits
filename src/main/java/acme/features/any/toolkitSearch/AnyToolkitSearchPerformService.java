package acme.features.any.toolkitSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Toolkit;
import acme.forms.ToolkitSearch;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractPerformService;

@Service
public class AnyToolkitSearchPerformService implements AbstractPerformService<Any, ToolkitSearch> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolkitSearchRepository repository;

	// AbstractPerformService<Any, ToolkitSearch> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<ToolkitSearch> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<ToolkitSearch> request, final ToolkitSearch entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "artifact", "toolkit");
		
	}

	@Override
	public void unbind(final Request<ToolkitSearch> request, final ToolkitSearch entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		List<String> allArtifact;
		allArtifact = this.repository.findAllArtifact();
		
		request.unbind(entity, model, "artifact", "toolkit");
		model.setAttribute("allArtifact", allArtifact);
	}

	@Override
	public ToolkitSearch instantiate(final Request<ToolkitSearch> request) {
		assert request != null;
		
		ToolkitSearch result;
		result = new ToolkitSearch();
			
		return result;
	}

	@Override
	public void validate(final Request<ToolkitSearch> request, final ToolkitSearch entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void perform(final Request<ToolkitSearch> request, final ToolkitSearch entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		
		Artifact artifact;
		List<Toolkit> toolkit;
		ToolkitSearch result;
		String artifactName;
		
		artifactName = request.getModel().getString("artifact");
		artifact = this.repository.findArtifactByName(artifactName);
		result = this.computeToolKitSearch(artifact);
		errors.state(request, result != null, "*", "any.toolkit-search.messages.error");
		if(result == null) {
			entity.setToolkit(null);
		}else {
			toolkit = result.getToolkit();
			entity.setToolkit(toolkit);
		}
		
	}
	
	private ToolkitSearch computeToolKitSearch(final Artifact artifact) {
		List<Toolkit> toolkit;
		ToolkitSearch result;
		
		if(artifact==null) {
			return null;
		}
		
		toolkit = this.repository.findToolkitByArtifactId(artifact.getId());
		if(toolkit == null) {
			result = null;
		}else {
			result = new ToolkitSearch();
			result.setArtifact(artifact);
			result.setToolkit(toolkit);
		}
			
		return result;
		
	}

}
