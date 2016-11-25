package com.rmk.formatter.reader;

import com.rmk.formatter.exception.ReaderException;

/**
 * Interface for reading symbol streams.
 * @param <T> symbol type that will be read.
 */
public interface IReader<T> {
    /**
     * Kind of facade over stream.ready method.
     * @return true if stream still has chars in it.
     * @throws ReaderException when IO exceptions occur.
     */
    boolean hasChars() throws ReaderException;

    /**
     * Reads symbol and returns it.
     * @return char that was read.
     * @throws ReaderException when IO exceptions occur.
     */
    T readChar() throws ReaderException;
}
