package invoice;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    @Test
    void verifyEqualsAndHashCodeMethods(){
        EqualsVerifier.forClass(Invoice.class).verify();
    }
}