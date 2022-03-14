/*
 * Patronage.java
 *
 * Copyright (C) 2012-2022 David Zamora.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.entities.patronage;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patronage extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotNull
	protected Status			status;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String			code;

	@NotBlank
	@Length(max=255)
	@NotNull
	protected String			legalStuff;

	@Positive
	@NotNull
	protected Float				budget;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Future
	protected LocalDate				startDate;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Future
	protected LocalDate				finishDate;
	
	@URL
	protected Date				link;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
