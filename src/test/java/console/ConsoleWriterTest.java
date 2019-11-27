package console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

class ConsoleWriterTest {
    @Test
    @DisabledOnOs(WINDOWS)
    void concatAndPrintTwoStringsReturnsConcatenatedVersion() {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        ConsoleWriter writer = new ConsoleWriter(new PrintStream(outSpy));

        writer.concatAndPrint("Text1","Text2");
//+ System.getProperty("line.separator")
        assertEquals( "Text1Text2\n" , outSpy.toString() );
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void concatAndPrintTwoStringsReturnsConcatenatedVersionWindowsStyle() {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        ConsoleWriter writer = new ConsoleWriter(new PrintStream(outSpy));

        writer.concatAndPrint("Text1","Text2");
//+ System.getProperty("line.separator")
        assertEquals( "Text1Text2\r\n" , outSpy.toString() );
    }

}