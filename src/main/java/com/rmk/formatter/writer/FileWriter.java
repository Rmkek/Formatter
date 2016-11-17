package com.rmk.formatter.writer;

import com.rmk.formatter.exception.WriterException;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


/**
 * Class for writing into files. Implements IWriter interface.
 */
public class FileWriter implements IWriter {

    private PrintWriter writer;

    /**
     * Constructor for initializing writer. Takes filepath and encoding.
     * @param filePath file that will be written to.
     * @param encode file encoding.
     * @throws WriterException thrown when IO exceptions occur.
     */
    public FileWriter(final String filePath, final String encode) throws WriterException {
        try {
            writer = new PrintWriter(filePath, encode);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            throw new WriterException("Exception happened when initializing writer.", ex);
        }
    }

    @Override
    public void writeChar(final char c) {
        writer.write(c);
    }

    @Override
    public void close() {
        writer.close();
    }

}
