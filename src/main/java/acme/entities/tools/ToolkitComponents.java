package acme.entities.tools;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.entities.components.Component;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ToolkitComponents")
public class ToolkitComponents extends AbstractEntity{

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@ManyToOne(optional = true)
	@Valid
	@NotNull
	protected Toolkit			toolkit;
	
	@ManyToOne(optional = true)
	@Valid
	@NotNull
	protected Component			component;
	
	
	
}
