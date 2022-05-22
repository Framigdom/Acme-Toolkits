package acme.testing.administrator.configData;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorConfigDataUpdateTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/config-data/update.csv" , encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String systemCurrency, final String acceptedCurrencies, final String strongSpamTerms,final String weakSpamTerms, final int strongSpamTreshold, final int weakSpamTreshold) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "System Configuration Data");
		super.checkFormExists();
		
		super.fillInputBoxIn("systemCurrency", systemCurrency);
		super.fillInputBoxIn("acceptedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongSpamTerms", strongSpamTerms);
		super.fillInputBoxIn("weakSpamTerms", weakSpamTerms);
		super.fillInputBoxIn("strongSpamTreshold", String.valueOf(strongSpamTreshold));
		super.fillInputBoxIn("weakSpamTreshold", String.valueOf(weakSpamTreshold));
		super.clickOnSubmit("Update the System Configuration Data");	//Datos actualizados -> falta comprobar
				
		
		super.clickOnMenu("Administrator", "System Configuration Data");
		super.checkFormExists();

		super.checkInputBoxHasValue("systemCurrency", systemCurrency);
		super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
		super.checkInputBoxHasValue("strongSpamTerms", strongSpamTerms);
		super.checkInputBoxHasValue("weakSpamTerms", weakSpamTerms);
		super.checkInputBoxHasValue("strongSpamTreshold", String.valueOf(strongSpamTreshold));
		super.checkInputBoxHasValue("weakSpamTreshold", String.valueOf(weakSpamTreshold));
		
		super.signOut();	
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/config-data/update-negative.csv" , encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String systemCurrency, final String acceptedCurrencies, final String strongSpamTerms,final String weakSpamTerms, final int strongSpamTreshold, final int weakSpamTreshold) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "System Configuration Data");
		super.checkFormExists();
		
		super.fillInputBoxIn("systemCurrency", systemCurrency);
		super.fillInputBoxIn("acceptedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongSpamTerms", strongSpamTerms);
		super.fillInputBoxIn("weakSpamTerms", weakSpamTerms);
		super.fillInputBoxIn("strongSpamTreshold", String.valueOf(strongSpamTreshold));
		super.fillInputBoxIn("weakSpamTreshold", String.valueOf(weakSpamTreshold));
		super.clickOnSubmit("Update the System Configuration Data");	//Datos actualizados -> falta comprobar
				
		super.checkErrorsExist();
		
		super.signOut();
	}

}
