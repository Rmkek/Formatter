package com.rmk.formatter.reader;

import com.rmk.formatter.exception.ReaderException;

/**
 * StringReader implementation.
 */
public class StringReader implements IReader {

    private String string;
    private int charNum = 0;

    /**
     * StringReader constructor that takes string as input.
     * @param str string that will be used for reading.
     */
    public StringReader(final String str) {
        this.string = str;
    }

    @Override
    public boolean hasChars() throws ReaderException {
        return (string.length() <= charNum) ? false :  true;
    }

    @Override
    public char readChar() throws ReaderException {
        return string.charAt(charNum++);
    }
}
