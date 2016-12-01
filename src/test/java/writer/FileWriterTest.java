package writer;

import com.rmk.formatter.exception.WriterException;
import com.rmk.formatter.writer.FileWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
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
        char[] text = "Yay! I can write!".toCharArray();
        for (char ch: text) {
            writer.writeChar(ch);
        }
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
        char[] text = "test".toCharArray();

        for(char ch: text) {
            writer.writeChar(ch);
        }

        writer.close();
    }


}
