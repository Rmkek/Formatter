package com.rmk.formatter.writer;

/**
 * Interface for writing. Should be implemented by writer class.
 */
public interface IWriter {

    /**
     * Writes chars in implemented stream.
     * @param c chars that will be written.
     */
    void writeChars(char[] c);

    /**
     * Method for closing stream.
     */
    void close();

}
