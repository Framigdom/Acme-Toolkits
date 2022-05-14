package acme.testing.any.chirp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyChirpCreateTest extends TestHarness {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void create(final int recordIndex, final String title, final String author, final String moment, final String body, final String email) {
		
		super.clickOnMenu("Anonymous", "List chirps");
		super.checkListingExists();
		
		super.clickOnButton("New Chirp");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirm", "true");
		super.clickOnSubmit("Create Chirp");
		
		super.clickOnMenu("Anonymous", "List chirps");
		super.checkListingExists();
		super.sortListing(2, "desc");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
	}
}
