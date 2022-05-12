package acme.components.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import acme.features.patron.patronage.PatronPatronageRepository;
import acme.roles.Inventor;

public class InventorFormatter implements Formatter<Inventor> {

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected PatronPatronageRepository repository;
	
	// Formatter<Inventor> interface ---------------------------------------------
	
	@Override
	public String print(final Inventor object, final Locale locale) {
		String result;
		
		result = object.getUserAccount().getUsername();
		
		return result;
	}

	@Override
	public Inventor parse(final String text, final Locale locale) throws ParseException {
		Inventor result;
		
		result = this.repository.findInventorByUsername(text);
		if(result == null)
			throw new ParseException("No se encontro el inventor", 0);
		
		return result;
	}

}
