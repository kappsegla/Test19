package invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoH2 implements InvoiceDao {

    private Connection c;

    public InvoiceDaoH2() {
        try {
            if(c!=null) return;
            //http://www.h2database.com/html/features.html#in_memory_databases
            c = DriverManager.getConnection("jdbc:h2:mem:", "", "");
            c.prepareStatement("create table invoice (name varchar(100), value double)").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Invoice> all() {

        List<Invoice> allInvoices = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement("select * from invoice");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                double value = rs.getDouble("value");
                allInvoices.add(new Invoice(name, value));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return allInvoices;
        }

    }

    @Override
    public void save(Invoice inv) {
        try {
            PreparedStatement ps = c.prepareStatement("insert into invoice (name, value) values (?,?)");
            ps.setString(1, inv.getCustomer());
            ps.setDouble(2, inv.getValue());

            ps.execute();

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}