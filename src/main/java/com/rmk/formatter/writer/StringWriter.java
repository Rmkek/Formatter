package com.rmk.formatter.writer;

/**
 * Class for writing into string. Implements IWriter interface.
 */
public class StringWriter implements IWriter {
    private StringBuilder builder = new StringBuilder();

    /**
     * Closes the stream.
     */
    public void close() {
        getStringContent();
    }

    @Override
    public void writeChar(final char c) {
        builder.append(c);
    }

    public String getStringContent() {
        return builder.toString();
    }
}
