package com.rmk.formatter.writer;

import com.rmk.formatter.exception.WriterException;

/**
 * Interface for writing. Should be implemented by writer class.
 */
interface IWriter {

    /**
     * Method that takes String text, then writes text using OutputStream.
     * @param text text that will be written to stream.
     * @throws WriterException thrown if any exception occurs.
     */
    void write(String text) throws WriterException;

    /**
     * Method that closes OutputStream. Flushes stream before closing.
     * @throws WriterException thrown if any exception occurs.
     */
    void close() throws WriterException;

}
