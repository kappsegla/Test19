package invoice;

import java.util.Objects;
import java.util.Optional;

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

//@Override
//final public boolean equals(Object o) {
//    return Optional.ofNullable(o)
//            .filter(that -> that instanceof Invoice)
//            .map(that -> (Invoice) that)
//            .filter(that -> Objects.equals(this.customer, that.customer))
//            .filter(that -> Objects.equals(this.value, that.value))
//            .isPresent();
//}

    @Override
    final public int hashCode() {
        return Objects.hash(customer, value);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer='" + customer + '\'' +
                ", value=" + value +
                '}';
    }
}
