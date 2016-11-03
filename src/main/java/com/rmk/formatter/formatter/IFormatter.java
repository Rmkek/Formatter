package com.rmk.formatter.formatter;

import com.rmk.formatter.exception.ReaderException;
import com.rmk.formatter.exception.WriterException;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.writer.IWriter;


/**
 * Interface for formatting classes.
 */
public interface IFormatter {

    /**
     * Method that formats input code.
     * @param reader from which code will be read.
     * @param writer to which output will be written.
     * @throws ReaderException when reading exceptions occur.
     * @throws WriterException when writing exception occur.
     */
    void format(IReader reader, IWriter writer) throws ReaderException, WriterException;

}
