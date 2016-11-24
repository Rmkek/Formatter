package com.rmk.formatter.writer;

import com.rmk.formatter.exception.WriterException;

/**
 * WriterFactory class that returns IWriter implementations.
 */
public final class WriterFactory {

    private WriterFactory() {}

    /**
     * Method for getting writer.
     * @param type type of writer that will be returned.
     * @return IWriter implementation.
     * @throws WriterException when any exception occur.
     */
    public static IWriter getWriter(final String type) throws WriterException {
        if (type.contains("FileWriter")) {
            return new FileWriter(type.substring("FileWriter, ".length(), type.length()), "UTF-8");
        } else {
            return new StringWriter();
        }
    }
}
