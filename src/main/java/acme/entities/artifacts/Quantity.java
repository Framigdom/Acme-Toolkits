package acme.entities.artifacts;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quantity extends AbstractEntity{

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@Min(1)
	protected int				amount;
	
	@ManyToOne(cascade=CascadeType.PERSIST, optional = true)
	@Valid
	@NotNull
	protected Toolkit			toolkit;
	
	@ManyToOne(cascade=CascadeType.PERSIST, optional = true)
	@Valid
	@NotNull
	protected Artifact			artifact;

	
}