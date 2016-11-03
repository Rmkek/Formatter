package com.rmk.formatter.formatter;

import com.rmk.formatter.exception.ReaderException;
import com.rmk.formatter.exception.WriterException;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.writer.IWriter;

/**
 * IFormatter implementation.
 */
public class Formatter implements IFormatter {

    @Override
    public void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException {
        char tmp = 0;

        while (reader.hasChars()) {
            tmp = reader.readChar();
            int curlyBracketsAmount = 0;

            if (tmp == '\n' && curlyBracketsAmount < 1) {
                writer.writeChars(";\n".toCharArray());
            }

            if (tmp == '{') {
                ++curlyBracketsAmount;
                continue;
            }

            if (tmp == ')') {
                writer.writeChars(") {\n".toCharArray());
                ++curlyBracketsAmount;
                continue;
            }

            if (curlyBracketsAmount >= 1 && tmp != ' ') {
                writer.writeChars("    ".toCharArray());
            }

            if (tmp == '}') {
                --curlyBracketsAmount;
            }

            writer.writeChars(new char[] {tmp});
        }

        if (tmp != '}') {
            writer.writeChars("\n}".toCharArray());
        }

        writer.close();

    }
}
