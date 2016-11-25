import com.rmk.formatter.exception.ReaderException;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.reader.StringReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReaderTest {
    private IReader reader;

    @Before
    public void setUp() throws ReaderException {
        reader = new StringReader("void myFunction(String test){help();");
    }

    @Test
    public void testReaderHasChars() throws Exception {
        boolean b = reader.hasChars();
        assertEquals(true, b);
    }

    @Test
    public void testReaderCanReadChar() throws Exception {
        char c = (char) reader.readChar();
        assertEquals('v', c);
    }

    @Test
    public void testReaderCanReadALotOfChars() throws Exception {
        StringBuilder builder = new StringBuilder(20);
        while (reader.hasChars()) {
            builder.append(reader.readChar());
        }
        assertEquals(builder.toString(), "void myFunction(String test){help();");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testReaderReturnsOutOfBounds() throws Exception {
        while (reader.hasChars()) {
            reader.readChar();
        }
        char ch = (char) reader.readChar();
    }

}

