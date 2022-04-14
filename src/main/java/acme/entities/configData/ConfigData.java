package acme.entities.configData;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ConfigData extends AbstractEntity{

    // Serialisation identifier -----------------------------------------------

    protected static final long    serialVersionUID    = 1L;

    // Attributes -------------------------------------------------------------

    @NotBlank
    public String             systemCurrency;
    
    @NotBlank
    public String             acceptedCurrencies;

    @NotBlank
    public String             strongSpamTerms;
    
    @NotBlank
    public String			  weakSpamTerms;

    @Range(min = 0, max = 100)
    public int                strongSpamTreshold;
    
    @Range(min = 0, max = 100)
    public int                weakSpamTreshold;

}
