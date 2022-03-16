package acme.components;

import java.util.List;

public class Data {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	public String 			systemCurrency;
	public List<String> 	acceptedCurrencies;
	public String 			strongSpamTerms;
	public String			weakSpamTerms;
	public Double 			strongSpamTreshold;
	public Double			weakSpamTreshold;
	
	
}
