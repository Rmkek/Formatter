package reader;

import com.rmk.formatter.exception.ReaderException;
import com.rmk.formatter.reader.FileReader;
import com.rmk.formatter.reader.IReader;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {
    private IReader reader;

    @Before
    public void setUp() throws ReaderException {
        reader = new FileReader("Test_Read.txt");
    }

    @Test
    public void testReaderHasChars() throws Exception {
        boolean b = reader.hasChars();
        assertEquals(true, b);
    }

    @Test
    public void testReaderCanReadChar() throws Exception {
        char c = (char) reader.readChar();
        assertEquals('T', c);
    }

    @Test
    public void testReaderCanReadALotOfChars() throws Exception {
        StringBuilder builder = new StringBuilder(20);
        while (reader.hasChars()) {
            builder.append(reader.readChar());
        }
        assertEquals(builder.toString(), "Testing FileReader.");
    }

    @Test
    public void testReaderReturnsNull() throws Exception {
        while (reader.hasChars()) {
            reader.readChar();
        }
        char ch = (char) reader.readChar();
        assertEquals('\uFFFF', ch);
    }

    @Test(expected = ReaderException.class)
    public void testFileNotFound() throws Exception {
        FileReader reader = new FileReader("test");
    }

    @Test(expected = ReaderException.class)
    public void testReaderCantGetChars() throws Exception {
        IReader reader = mock(FileReader.class);
        when(reader.readChar()).thenThrow(ReaderException.class);
        reader.readChar();
    }

    @Test(expected = ReaderException.class)
    public void testReaderCantUseHasCharsMethod() throws Exception {
        IReader reader = mock(FileReader.class);
        when(reader.hasChars()).thenThrow(ReaderException.class);
        reader.hasChars();
    }
}

/* TODO: Try to get 100% code-coverage with reflection calls and exception throws.
   @Test (expected = ReaderException.class)
    public void testReaderFallsWithIOException() throws Exception {
        Class reader = FileReader.class;
        Class[] paramTypes = new Class[]{Void.class};
        Method method = reader.getDeclaredMethod("readChar");
        method.setAccessible(true);
        method.invoke(reader.newInstance());
    }
}*/
