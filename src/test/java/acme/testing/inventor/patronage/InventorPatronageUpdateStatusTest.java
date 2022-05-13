package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageUpdateStatusTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/updateStatus.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code,final String legalStuff, final String budget, final String startDate, final String finishDate, final String link) {
		super.signIn("inventor2", "inventor2");
		
		super.clickOnMenu("Inventor", "Patronages");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnSubmit("Accept");
		
		super.checkListingExists();
		super.checkColumnHasValue(recordIndex, 0, "ACCEPTED");
		
		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------
	
}
