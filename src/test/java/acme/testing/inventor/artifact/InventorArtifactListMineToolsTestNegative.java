package acme.testing.inventor.artifact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorArtifactListMineToolsTestNegative extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artifact/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String artifactType, final String name, final String code, final String technology, final String description, final String retailPrice, final String link) {
		super.signIn("patron1", "patron1");

		super.navigate("/inventor/artifact/list-mine", "type=tool");
		super.checkErrorsExist();

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------


}
