package formatter;

import com.rmk.formatter.formatter.Formatter;
import com.rmk.formatter.formatter.StateManager;
import com.rmk.formatter.reader.FileReader;
import com.rmk.formatter.reader.StringReader;
import com.rmk.formatter.writer.FileWriter;
import com.rmk.formatter.writer.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    private Formatter formatter;

    @Before
    public void setUp() throws Exception {
        formatter = new Formatter();
    }

    @Test
    public void testFormat() throws Exception {
        FileReader reader = new FileReader("Test_Read.txt");
        FileWriter writer = new FileWriter("Test_Write.txt", "UTF-8");

        formatter.format(reader, writer, new StateManager());
    }

    @Test
    public void testFormatWithString() throws Exception {
        StringReader reader = new StringReader("void myFunction(String test){help();\n");
        StringWriter writer = new StringWriter();

        formatter.format(reader, writer, new StateManager());
        assertEquals(writer.getStringContent(), "void myFunction(String test)         test();\n");
    }

    @Test
    public void testFormatWithStringAndComments() throws Exception {
        StringReader reader = new StringReader("void myFunction(String test){help();\n//test\n/* wow" +
                "\nmulti\nline\ncomment!!!\n*/");
        StringWriter writer = new StringWriter();

        formatter.format(reader, writer, new StateManager());
        assertEquals(writer.getStringContent(), "void myFunction(String test)     help();\n" +
                "//test\n" +
                "/* wow\n" +
                "multi\n" +
                "line\n" +
                "comment!!!\n" +
                "*/");
    }
}
