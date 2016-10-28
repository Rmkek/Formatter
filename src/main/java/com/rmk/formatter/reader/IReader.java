package com.rmk.formatter.reader;

/**
 * Interface for reading files.
 */
interface IReader {


    /**
     * Singleton that returns stream from which data will be read.
     * @param file from which InputStream will be created.
     * @return InputStream with createn from file.
     * @throws ReaderException when any exception with reading occurs.
     */
    //public static InputStream getReader(String file) throws ReaderException;

}
