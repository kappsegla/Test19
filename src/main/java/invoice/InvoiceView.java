package invoice;

import java.io.PrintStream;

public class InvoiceView {

    private PrintStream output;

    public InvoiceView(PrintStream outSpy) {
        this.output = outSpy;
    }

    public void printInvoice(Invoice invoice){
        output.println("Customer: " + invoice.getCustomer());
        output.println("Amount: " + invoice.getValue());
    }

    public static void main(String[] args) {
        new InvoiceView(System.out).run();
    }

    public void run(){
        InvoiceDao invoiceDaoH2 = new InvoiceDaoH2();
        InvoiceFilter invoiceFilter = new InvoiceFilter(invoiceDaoH2);

        invoiceDaoH2.save(new Invoice("Martin",99));
        invoiceDaoH2.save(new Invoice("Kalle",100));

        invoiceFilter.filter().forEach(this::printInvoice);

        invoiceDaoH2.close();
    }
}
