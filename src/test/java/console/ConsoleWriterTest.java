package console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

class ConsoleWriterTest {
    @Test
    @DisabledOnOs(WINDOWS)
    void concatAndPrintTwoStringsReturnsConcatenatedVersion() {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        ConsoleWriter writer = new ConsoleWriter(new PrintStream(outSpy));

        writer.concatAndPrint("Text1", "Text2");
//+ System.getProperty("line.separator")
        assertEquals("Text1Text2\n", outSpy.toString());
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void concatAndPrintTwoStringsReturnsConcatenatedVersionWindowsStyle() {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        ConsoleWriter writer = new ConsoleWriter(new PrintStream(outSpy));

        writer.concatAndPrint("Text1", "Text2");

        //assertEquals( "Text1Text2\r\n" , outSpy.toString() );
        //AssertJ style
        assertThat(outSpy.toString())
                .as("Concatenated strings")
                .startsWith("Text1Text2")
                .endsWith("\r\n");
    }


    @Test
    void fileTest(@TempDir Path tempPath){

            tempPath.resolve("file.txt");

    }

}