package com.rmk.formatter.reader;

import com.rmk.formatter.exception.ReaderException;

import java.io.*;

//TODO: Rebuild this stuff using IReader interface.

public class ReaderBuilder {

    private static FileReader inputStream;

    public static FileReader setReader(String file) throws  ReaderException {
        try {
            inputStream = new FileReader(file);
        } catch (FileNotFoundException ex) {
            throw new ReaderException("File not found.", ex);
        }
        return inputStream;
    }

}
