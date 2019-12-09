package invoice;

import java.util.List;

public interface InvoiceDao {
    List<Invoice> all();

    void save(Invoice inv);

    void close();
}
