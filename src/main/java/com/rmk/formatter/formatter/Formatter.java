package com.rmk.formatter.formatter;

import com.rmk.formatter.exception.FormatterException;
import com.rmk.formatter.formatter.command.CommandChooser;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.writer.IWriter;

/**
 * IFormatter implementation.
 */
public class Formatter implements IFormatter {
    private static final int TMP_CHARS_AMOUNT = 3;
    private static final int ANTI_MAGIC_NUMBER = 3;

    private char[] tmpChars = new char[TMP_CHARS_AMOUNT]; //TODO: refactor me!

    @Override
    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        try {
            CommandChooser chooser = new CommandChooser();
            chooser.getCommand(reader, writer);
        } catch (Exception ex) {
            throw new FormatterException(ex);
        }
    }
}
