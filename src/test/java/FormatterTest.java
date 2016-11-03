import com.rmk.formatter.formatter.Formatter;
import com.rmk.formatter.reader.FileReader;
import com.rmk.formatter.writer.FileWriter;
import org.junit.Before;
import org.junit.Test;

public class FormatterTest {
    Formatter formatter;

    @Before
    public void setUp() throws Exception {
        formatter = new Formatter();
    }

    @Test
    public void testFormat() throws Exception {
        FileReader reader = new FileReader("Test_Read.txt");
        FileWriter writer = new FileWriter("Test_Write.txt", "UTF-8");

        formatter.format(reader, writer);
    }
}
