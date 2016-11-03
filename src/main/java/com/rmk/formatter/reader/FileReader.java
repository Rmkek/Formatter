package com.rmk.formatter.reader;

import com.rmk.formatter.exception.ReaderException;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * FileReader implementation.
 */
public class FileReader implements IReader {

    private BufferedReader reader;


    /**
     * FileReader constructor with filePath.
     * @param filePath from what path FileReader will be created.
     * @throws ReaderException when FileNotFoundException occurs.
     */
    public FileReader(final String filePath) throws ReaderException {
        try {
            reader = new BufferedReader(new java.io.FileReader(filePath));
        } catch (FileNotFoundException ex) {
            throw new ReaderException("File not found.", ex);
        }
    }

    @Override
    public boolean hasChars() throws ReaderException {
        try {
            return reader.ready();
        } catch (IOException e) {
            throw new ReaderException("Exception when checking file for chars.", e);
        }
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            return (char) reader.read();
        } catch (IOException ex) {
            throw new ReaderException("Exception when reading from file.", ex);
        }
    }


}
