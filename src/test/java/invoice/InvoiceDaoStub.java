package invoice;

import java.util.List;

public class InvoiceDaoStub extends InvoiceDao {

    public InvoiceDaoStub() {

    }

    @Override
    public List<Invoice> all() {
        return List.of(new Invoice("Martin", 100),
                new Invoice("Kalle", 99),
                new Invoice("Maja", 10),
                new Invoice("Amid", 200));
    }

    @Override
    public void save(Invoice inv) {

    }

    @Override
    public void close() {

    }
}
