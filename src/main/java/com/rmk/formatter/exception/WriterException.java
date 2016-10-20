package com.rmk.formatter.exception;

/**
 * Exception class used by IReader implementations. Thrown when any writing exception occurs.
 */
public class WriterException extends Exception {

    public WriterException(String text, Throwable exception) { super(text, exception); }

    public WriterException(Throwable exception) { super(exception); }

}
