package invoice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvoiceFilterTest {

    @Mock InvoiceDao invoiceDao;
    @Mock List<String> listOfStrings;

    @Test
    @Disabled
    void filterReturnsListOfInvoicesWithValueLessThan100() {
        InvoiceDao invoiceDao = new InvoiceDaoStub();

        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        var invoiceList = filter.filter();

        assertEquals(2, invoiceList.size());
    }

    @Test
    void filterReturnsListOfInvoicesWithValueLessThan100UsingMockedObject() {

        //InvoiceDao invoiceDao = mock(InvoiceDao.class);
        when(invoiceDao.all()).thenReturn(List.of(new Invoice("Martin", 100),
                new Invoice("Kalle", 99),
                new Invoice("Maja", 10),
                new Invoice("Amid", 200)));

        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        var invoiceList = filter.filter();

        assertEquals(2, invoiceList.size());
    }

    @Test
    void filterReturnsListOfInvoicesWithValueLessThan100UsingMockedObject2() {

        //InvoiceDao invoiceDao = mock(InvoiceDao.class);
        when(invoiceDao.all()).thenReturn(List.of(new Invoice("Martin", 100),
                new Invoice("Kalle", 99),
                new Invoice("Maja", 10),
                new Invoice("Amid", 200)));

        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        var invoiceList = filter.filter();

        assertEquals(2, invoiceList.size());
    }

    @Test
    void test()
    {
        listOfStrings.add("Test");

        when(listOfStrings.size()).thenReturn(1);
        System.out.println(listOfStrings.size());
        verify(listOfStrings).add("Test");
    }

}