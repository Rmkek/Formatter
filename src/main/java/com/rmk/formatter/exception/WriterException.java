package com.rmk.formatter.exception;

/**
 * Exception class used by IReader implementations. Thrown when any writing exception occurs.
 */
public class WriterException extends Exception {
    /**
     * Method for WriterException.
     *
     * @param text      why exception was thrown.
     * @param exception any Throwable.
     */
    public WriterException(final String text, final Throwable exception) {
        super(text, exception);
    }

    /**
     * Method for WriterException.
     *
     * @param exception any Throwable.
     */
    public WriterException(final Throwable exception) {
        super(exception);
    }

}
