package com.rmk.formatter.exception;

/**
 * Exception class used by IFormatter implementations. Thrown when any reading exception occur.
 */
public class FormatterException extends Exception {

    /**
     * Method for FormatterException.
     *
     * @param text      why exception was thrown.
     * @param exception any Throwable.
     */
    public FormatterException(final String text, final Throwable exception) {
        super(text, exception);
    }

    /**
     * Method for FormatterException.
     *
     * @param exception any Throwable.
     */
    public FormatterException(final Throwable exception) {
        super(exception);
    }

}
