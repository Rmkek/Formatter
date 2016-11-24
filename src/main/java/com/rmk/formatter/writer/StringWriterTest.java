package com.rmk.formatter.writer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringWriterTest {
    private StringWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = new StringWriter();
    }

    @Test
    public void testWriterCanWrite() throws Exception {
        char[] text = "Yay! I can write!".toCharArray();
        for(char ch: text) {
            writer.writeChar(ch);
        }

        String str = writer.getStringContent();
        assertEquals(str, "Yay! I can write!");
    }

    @Test
    public void testWriterCanCloseItself() throws Exception {
        writer.close();
    }

    @Test
    public void testWriterCanWriteChar() throws Exception {
        writer.writeChar('\u0000');
        assertEquals(writer.getStringContent(), "\u0000");
    }

}
