package acme.testing.any.artifact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyArtifactListToolsTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/artifact/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String artifactType, final String name, final String code, final String technology,final String description, final String retailPrice, final String link) {
		
		super.clickOnMenu("Anonymous", "List of Tools");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, retailPrice);
		super.checkColumnHasValue(recordIndex, 3, artifactType);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("artifactType", artifactType);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("link", link);
		
	}

	
	// Ancillary methods ------------------------------------------------------

}
