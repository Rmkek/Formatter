package com.rmk.formatter.exception;

/**
 * Exception class used by IReader implementations. Thrown when any reading exception occur.
 */
public class ReaderException extends Exception {

    public ReaderException(String text, Throwable exception) { super(text, exception); }

    public ReaderException(Throwable exception) { super(exception); }

}
