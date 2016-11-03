package com.rmk.formatter.reader;

import com.rmk.formatter.exception.ReaderException;

/**
 * Interface for reading files.
 */
public interface IReader {
    /**
     * Kind of facade over stream.ready method.
     * @return true if stream still has chars in it.
     * @throws ReaderException when IO exceptions occur.
     */
    boolean hasChars() throws ReaderException;

    /**
     * Reads char and returns it.
     * @return char that was read.
     * @throws ReaderException when IO exceptions occur.
     */
    char readChar() throws ReaderException;
}
