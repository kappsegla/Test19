package invoice;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.util.logging.Level.*;

public class InvoiceView {

    //-Djava.util.logging.config.file=./logging.properties
    static Handler fileHandler = null;
    public static void setup() {
        try {
            fileHandler = new FileHandler("./logfile.log",true);//file
            fileHandler.setLevel(FINER);
            SimpleFormatter simple = new SimpleFormatter();
            fileHandler.setFormatter(simple);
            LOGGER.addHandler(fileHandler);//adding Handler for file
            LOGGER.setLevel(FINER);
        } catch ( IOException e) {
            // TODO Auto-generated catch block
        }
    }

    final static Logger LOGGER = Logger.getLogger(InvoiceView.class.getName());

    private PrintStream output;

    public InvoiceView(PrintStream outSpy) {
        this.output = outSpy;
    }

    public void printInvoice(Invoice invoice){
        output.println("Customer: " + invoice.getCustomer());
        output.println("Amount: " + invoice.getValue());
    }

    public static void main(String[] args) {
       // setup();
        new InvoiceView(System.out).run();
    }

    public void run(){

        int i = 2;
        int k = 3;

        LOGGER.log(INFO,"Method run just started up...");
        LOGGER.info("An info log message");
        LOGGER.log(WARNING,"You have been warned.");
        LOGGER.log(INFO,"This is a log message for variable i: {0} : {1}", new Object[]{ i, k});
        LOGGER.log(FINE,"Detailed log message");

        InvoiceDao invoiceDaoH2 = new InvoiceDaoH2();
        InvoiceFilter invoiceFilter = new InvoiceFilter(invoiceDaoH2);

        invoiceDaoH2.save(new Invoice("Martin",99));
        invoiceDaoH2.save(new Invoice("Kalle",100));

        invoiceFilter.filter().forEach(this::printInvoice);

        invoiceDaoH2.close();
    }
}
