package invoice;


/* An integration test verifies the workings of a complete program,
 a module, or a set of dependant classes.*/

import console.ConsoleWriter;
import org.junit.Ignore;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InvoiceTestIT {
    @Test
    @Order(1)
    void invoiceFilterIntegrationTestWithDatabaseBackendFindsOneInvoice() {
        //fail("This integration test is supposed to fail. Must be implemented for real soon.");
        InvoiceDao invoiceDao = new InvoiceDaoH2();
        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        invoiceDao.save(new Invoice("Martin", 99));

        List<Invoice> invoices = filter.filter();

        invoiceDao.close();

        assertEquals(1, invoices.size());
        assertEquals("Martin", invoices.get(0).getCustomer());
    }

    @Test
    @Order(2)
    void invoiceViewPrintsOneInvoice() throws InterruptedException {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();

        InvoiceView view = new InvoiceView(new PrintStream(outSpy));
        view.run();

        String lf = System.getProperty("line.separator");
        assertEquals("Customer: Martin"+lf+"Amount: 99.0"+lf, outSpy.toString());
    }
}

