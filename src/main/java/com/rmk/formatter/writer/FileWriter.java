package com.rmk.formatter.writer;

import com.rmk.formatter.exception.WriterException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Class for writing into files. Implements IWriter interface.
 */
public class FileWriter implements IWriter {

    private OutputStream stream;


    @Override
    public void write(final String text) throws WriterException {
        try {
            stream.write(text.getBytes());
        } catch (IOException ex) {
            throw new WriterException("Exception occured when writing to OutputStream", ex);
        }
    }

    public void setWriter(final OutputStream outputStream) {
        this.stream = outputStream;
    }

    @Override
    public void close() throws WriterException {
        try {
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new WriterException("Exception occured when closing OutputStream.", e);
        }
    }
}
