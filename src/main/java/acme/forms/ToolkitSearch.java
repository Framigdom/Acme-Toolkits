package acme.forms;

import java.util.List;

import javax.validation.constraints.NotNull;

import acme.entities.artifacts.Artifact;
import acme.entities.artifacts.Toolkit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToolkitSearch {
	
	// Query attributes -------------------------------------------------------
	
	@NotNull
	public Artifact artifact;
	
	
	// Response attributes ----------------------------------------------------
	
	public List<Toolkit> toolkit;
	
}
