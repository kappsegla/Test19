package invoice;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceFilter {

    InvoiceDao invoiceDao;

    public InvoiceFilter(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public List<Invoice> filter() {

        List<Invoice> allInvoices = invoiceDao.all();

        return allInvoices.stream()
                .filter(invoice -> invoice.getValue() < 100.0)
                .collect(Collectors.toList());
    }
}