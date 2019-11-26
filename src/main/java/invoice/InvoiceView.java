package invoice;

public class InvoiceView {
    public void printInvoice(Invoice invoice){
        System.out.println("Customer: " + invoice.getCustomer());
        System.out.println("Amount: " + invoice.getValue());
    }
}
