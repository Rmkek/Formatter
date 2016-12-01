package com.rmk.formatter.writer;

/**
 * Interface for writing. Should be implemented by writer class.
 * @param <T> used for symbols.
 */
public interface IWriter<T> {

    /**
     * Writes symbol in implemented stream.
     * @param c char that will be written.
     */
<<<<<<< HEAD
    void writeChar(final T c);
=======
    void writeChar(T c);
>>>>>>> 46595803a37b4becfbe52ad7f98f24c8428aab2e

    /**
     * Method for closing stream.
     */
    void close();

}
