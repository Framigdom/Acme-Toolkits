package acme.testing.any.chirp;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.chirps.Chirp;
import acme.features.any.chirp.AnyChirpRepository;
import acme.framework.helpers.FactoryHelper;
import acme.testing.TestHarness;

public class AnyChirpListTest extends TestHarness {
	
	@Autowired
    private AnyChirpRepository repository;

    @Override
    @BeforeAll
    public void beforeAll() {
        super.beforeAll();
        FactoryHelper.autowire(this);
        this.patchChirps();
    }

    protected void patchChirps() {
        Collection<Chirp> chirps;
        Date moment = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(moment);
        calendar.add(Calendar.DATE, -1);
        moment = calendar.getTime();

        chirps = this.repository.findAllChirp();
        for (final Chirp chirp : chirps) {

            chirp.setMoment(moment);
            this.repository.save(chirp);
        }
    }
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final String author, final String moment, final String body, final String email) {
		
		super.clickOnMenu("Anonymous", "List chirps");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, moment);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);		
	}
}
