package com.rmk.formatter.writer;

/**
 * Interface for writing. Should be implemented by writer class.
 * @param <T> type of char written.
 */
public interface IWriter<T> {

    /**
     * Writes symbol in implemented stream.
     * @param c char that will be written.
     */
    void writeChar(final T c);

    /**
     * Method for closing stream.
     */
    void close();

}
