package invoice;

import java.util.List;

public interface InvoiceDao {
    void InvoiceDao();

    List<Invoice> all();

    void save(Invoice inv);

    void close();

    default boolean test(){return false;}
}
