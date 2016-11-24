package com.rmk.formatter.writer;

/**
 * Interface for writing. Should be implemented by writer class.
 */
public interface IWriter {

    /**
     * Writes char in implemented stream.
     * @param c char that will be written.
     */
    void writeChar(final char c);

    /**
     * Method for closing stream.
     */
    void close();

}
