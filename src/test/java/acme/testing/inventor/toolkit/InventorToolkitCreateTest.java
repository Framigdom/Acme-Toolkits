package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;
public class InventorToolkitCreateTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/create-positive-toolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final String code, final String description, final String assemblyNotes, final String link, final String price) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My toolkits");
		super.checkListingExists();

		super.clickOnButton("Create new toolkit");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("assemblyNotes", assemblyNotes);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create new toolkit");

		super.clickOnMenu("Inventor", "My toolkits");
		super.checkListingExists();
		super.sortListing(0, "desc");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, description);	
		
		super.clickOnListingRecord(0);
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);
		super.checkInputBoxHasValue("link", link);

		super.clickOnButton("See tools and components of the toolkit");

		super.checkListingExists();
		super.checkListingEmpty();

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/create-negative-toolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex, final String title, final String code, final String description, final String assemblyNotes, final String link, final String price) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My toolkits");
		super.checkListingExists();

		super.clickOnButton("Create new toolkit");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("assemblyNotes", assemblyNotes);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create new toolkit");
		
		super.checkErrorsExist();

		super.signOut();
		
	}
		
	// Ancillary methods ------------------------------------------------------
}
