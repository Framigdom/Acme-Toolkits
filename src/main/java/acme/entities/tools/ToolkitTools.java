package acme.entities.tools;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ToolkitTools", uniqueConstraints = @UniqueConstraint(columnNames = {"toolkit, tool"}))
public class ToolkitTools extends AbstractEntity{

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
	protected Tool				tool;
	
	
	
}
