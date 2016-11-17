package com.rmk.formatter.reader;

import com.rmk.formatter.exception.ReaderException;

/**
 * ReaderFactory class that returns IReader implementations.
 */
public final class ReaderFactory {
    private ReaderFactory() {}

    /**
     * Method for getting reader.
     * @param type what type of reader will be returned.
     * @return IReader implementation.
     * @throws ReaderException when any exception occurs.
     */
    public static IReader getReader(final String type) throws ReaderException {
        if (type.contains("FileReader")) {
            return new FileReader(type.substring("FileReader, ".length(), type.length()));
        } else {
            return new StringReader(type);
        }
    }
}
