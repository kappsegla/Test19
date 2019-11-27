package invoice;

import java.util.Objects;

public class Invoice {

    final private String customer;
    final private double value;

    public Invoice(String customer, double value) {
        this.customer = customer;
        this.value = value;
    }

    public String getCustomer() {
        return customer;
    }

    public double getValue() {
        return value;
    }


    @Override
    final public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Invoice))
            return false;
        Invoice invoice = (Invoice) o;

        if (Double.compare(invoice.value, value) != 0) return false;
        return customer != null ? customer.equals(invoice.customer) : invoice.customer == null;
    }

    @Override
    final public int hashCode() {
        return Objects.hash(customer, value);
    }
}
