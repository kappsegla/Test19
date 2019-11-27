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

//        List<Invoice> filtered = new ArrayList<>();
//
//        for(Invoice inv : allInvoices) {
//            if(inv.getValue() < 100.0)
//                filtered.add(inv);
//        }
//
//        return filtered;
    }
}