package invoice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceFilterTest {

    @Test
    void filterReturnsListOfInvoicesWithValueLessThan100()
    {
        InvoiceDao invoiceDao = new InvoiceDaoStub();

        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        var invoiceList = filter.filter();

        assertEquals(2, invoiceList.size());
    }



}