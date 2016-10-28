package com.rmk.formatter.reader;

import com.rmk.formatter.exception.ReaderException;

import java.io.FileNotFoundException;
import java.io.FileReader;


//TODO: Rebuild this stuff using IReader interface.

/**
 * Class for getting reader instance. Probably singleton.
 */
final class ReaderBuilder {

    private ReaderBuilder() {
    }

    /**
     * Method for setting reader in ReaderBuilder.
     *
     * @param file string from which reader will be created.
     * @return FileReader stream.
     * @throws ReaderException when any exception with creating FileReader stream occurs.
     */
    static FileReader setReader(final String file) throws ReaderException {
        FileReader inputStream;
        try {
            inputStream = new FileReader(file);
        } catch (FileNotFoundException ex) {
            throw new ReaderException("File not found.", ex);
        }
        return inputStream;
    }

}
