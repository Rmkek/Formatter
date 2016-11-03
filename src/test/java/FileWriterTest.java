import com.rmk.formatter.exception.ReaderException;
import com.rmk.formatter.exception.WriterException;
import com.rmk.formatter.reader.FileReader;
import com.rmk.formatter.writer.FileWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FileWriterTest {
    FileWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = new FileWriter("Test_Write.txt", "UTF-8");
    }

    @Test
    public void testWriterCanWrite() throws Exception {
        Scanner scanner = new Scanner(new FileInputStream("Test_Write.txt"));
        writer.writeChars("Yay! I can write!".toCharArray());
        writer.close();
        assertEquals(scanner.nextLine(), "Yay! I can write!");
    }

    @Test
    public void testWriterCanCloseItself() throws Exception {
        writer.close();
    }

    @Test(expected = WriterException.class)
    public void testWriterThrowsWriterException() throws Exception {
        FileWriter writer = new FileWriter("test.txt", "ThereIsNoCharset");
        writer.writeChars("test".toCharArray());
        writer.close();
    }


}
