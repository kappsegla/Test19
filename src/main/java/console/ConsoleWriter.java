package console;

import java.io.PrintStream;
import java.util.*;

public class ConsoleWriter {

    //Inversion of Control
    PrintStream outStream;
//    List<String> list = Collections.unmodifiableList(new ArrayList<>());

    //Constructor Dependency Injection
    ConsoleWriter(PrintStream outStream){
        this.outStream = outStream;
    }

    //Setter Dependency Injection
    public void setOutStream(PrintStream outStream) {
        this.outStream = outStream;
    }

    public void concatAndPrint(String s1, String s2) {
        outStream.println(s1 + s2);
    }
}
