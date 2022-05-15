package acme.testing.authenticated.patron;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedPatronCreateTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/patron/create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String username, final String password, final String name, final String surname, final String email, final String company, final String statement, final String link) {
		super.signUp(username, password, name, surname, email);
		super.signIn(username, password);
		
		

		super.clickOnMenu("Account", "Become a patron");
		
		super.checkFormExists();
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Register");
		
		super.checkCurrentPath("/master/welcome");
		
		super.navigate("/patron/patronage/list");
		
		super.checkListingExists();
		
		super.checkListingEmpty();

		super.signOut();
	}
	
	@Test
	@Order(20)
	public void negative() {
		
		super.checkNotLinkExists("Account");	
		super.signIn("patron1", "patron1");
		
		super.navigate("/authenticated/patron/create");
		
		super.checkErrorsExist();
		
	}
	// Ancillary methods ------------------------------------------------------


}
