package invoice;

public class InvoiceView {
    public void printInvoice(Invoice invoice){
        System.out.println("Customer: " + invoice.getCustomer());
        System.out.println("Amount: " + invoice.getValue());
    }

    public static void main(String[] args) {
//        InvoiceView invoiceView = new InvoiceView();
//        InvoiceDaoHSQL invoiceDaoHSQL = new InvoiceDaoHSQL();
//        InvoiceFilter invoiceFilter = new InvoiceFilter(invoiceDaoHSQL);
//
//        invoiceDaoHSQL.save(new Invoice("Martin",99));
//
//        invoiceFilter.filter().forEach(invoiceView::printInvoice);
    }
}
