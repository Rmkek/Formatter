package com.rmk.formatter.writer;

import com.rmk.formatter.exception.WriterException;

import java.io.IOException;
import java.io.OutputStream;

public class FileWriter implements IWriter {

    OutputStream stream;


    @Override
    public void write(String text) throws WriterException {
        try {
            stream.write(text.getBytes());
        } catch(IOException ex) {
            throw new WriterException("Exception occured when writing to OutputStream", ex);
        }
    }

    public void setWriter(OutputStream stream) {
        this.stream = stream;
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
