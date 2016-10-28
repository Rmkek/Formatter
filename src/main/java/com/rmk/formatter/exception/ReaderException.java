package com.rmk.formatter.exception;

/**
 * Exception class used by IReader implementations. Thrown when any reading exception occur.
 */
public class ReaderException extends Exception {

    /**
     * Method for ReaderException.
     *
     * @param text      why exception was thrown.
     * @param exception any Throwable.
     */
    public ReaderException(final String text, final Throwable exception) {
        super(text, exception);
    }

    /**
     * Method for ReaderExceptions.
     *
     * @param exception any Throwable.
     */
    public ReaderException(final Throwable exception) {
        super(exception);
    }

}
