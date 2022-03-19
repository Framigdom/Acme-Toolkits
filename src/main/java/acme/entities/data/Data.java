package acme.entities.data;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Data {

    // Serialisation identifier -----------------------------------------------

    protected static final long    serialVersionUID    = 1L;

    // Attributes -------------------------------------------------------------

    @NotNull
    public String             systemCurrency;
    
    @NotNull
    public String             acceptedCurrencies;

    @NotNull
    public String             strongSpamTerms;
    
    @NotNull
    public String			  weakSpamTerms;

    public double             strongSpamTreshold;
    public double             weakSpamTreshold;

}
