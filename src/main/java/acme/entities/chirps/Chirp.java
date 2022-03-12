/*
 * Chirp.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.entities.chirps;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chirp extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@NotNull
	@Length(max=100)
	protected String				title;
	
	@NotBlank
	@NotNull
	@Length(max=100)
	protected String				author;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date					moment;

	@NotBlank
	@NotNull
	@Length(max=255)
	protected String				body;

	@Email
	protected String				email;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
