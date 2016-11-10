package com.rmk.formatter.formatter;

import com.rmk.formatter.exception.ReaderException;
import com.rmk.formatter.exception.WriterException;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.writer.IWriter;

/**
 * IFormatter implementation.
 */
public class Formatter implements IFormatter {
    private static final int TMP_CHARS_AMOUNT = 3;
    private static final int NULL_CHAR = 65535;
    private static final int AMOUNT_OF_SPACES = 4;
    private static final int ANTI_MAGIC_NUMBER = 3;

    private char[] tmpChars = new char[TMP_CHARS_AMOUNT];

    @Override
    public void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException {
        int curlyBracketsAmount = 0;
        int charsReaden = 1;
        char lastSymbol = NULL_CHAR;

        boolean ignoreString = false;
        boolean ignoreComment = false;


        while (reader.hasChars()) {
            tmpChars[0] = reader.readChar();

            if (tmpChars[0] == '\'' || tmpChars[0] == '\"') {
                tmpChars[1] = reader.readChar();
                writer.writeChars(new char[] {tmpChars[0], tmpChars[1]});

                while (tmpChars[1] != '\"' || tmpChars[1] != '\'') {
                    tmpChars[1] = reader.readChar();
                    writer.writeChar(tmpChars[1]);
                }
                lastSymbol = tmpChars[1];
                continue;
            }

            if (tmpChars[0] == '/') {
                tmpChars[1] = reader.readChar();
                writer.writeChars(new char[] {tmpChars[0], tmpChars[1]});
                char ch;
                char ch2;

                if (tmpChars[1] == '*') {
                    ch = reader.readChar();
                    ch2 = NULL_CHAR;
                    while (ch != '*' && ch2 != '/') {
                        ch = reader.readChar();
                        ch2 = reader.readChar();
                        writer.writeChars(new char[] {ch, ch2});
                    }
                    lastSymbol = ch2;
                    continue;
                }

                if (tmpChars[1] == '/') {
                    do {
                        ch = reader.readChar();
                        writer.writeChar(ch);
                    } while (ch != '\n' || ch == '\u0000');
                    lastSymbol = ch;
                    continue;
                }
            }

            if (lastSymbol == NULL_CHAR) {
                lastSymbol = tmpChars[0];
            }

            if (tmpChars[0] == '}') {
                --curlyBracketsAmount;
            }

            if (tmpChars[0] == '\n' && lastSymbol != ';' && lastSymbol != '/') {
                writer.writeChar(';');
            }

            if (curlyBracketsAmount > 0 && lastSymbol == '\n') {
                writer.writeChars(evalBracketsSpaces(curlyBracketsAmount));
            }

            if (tmpChars[0] == '{') {
                ++curlyBracketsAmount;
                tmpChars[1] = reader.readChar();

                if (tmpChars[1] != '\n') {
                    writer.writeChar(tmpChars[0]); // '{'
                    writer.writeChar('\n');
                    writer.writeChars(evalBracketsSpaces(curlyBracketsAmount));
                    writer.writeChar(tmpChars[1]);
                } else {
                    writer.writeChar(tmpChars[0]); // '{'
                    writer.writeChars(evalBracketsSpaces(curlyBracketsAmount));
                    writer.writeChar(tmpChars[1]);
                }
                continue;
            }

            switch (charsReaden) {
                case 1:
                    writer.writeChars(new char[] {tmpChars[0]});
                    break;
                case 2:
                    writer.writeChars(new char[] {tmpChars[0], tmpChars[1]});
                    break;
                case ANTI_MAGIC_NUMBER: //CheckStyle said that '3' is magic number?!
                    // Guess i'll fix it with constant, it will make more readable and obvious code.
                    writer.writeChars(new char[] {tmpChars[0], tmpChars[1], tmpChars[2]});
                    break;
                default:
                    break;
            }
            lastSymbol = tmpChars[0];
        }

        if (curlyBracketsAmount >= 1) {
            writer.writeChar('}');
        }

        writer.close();
    }

    private char[] evalBracketsSpaces(final int amountOfCurlyBrackets) {


        char[] str = new char[amountOfCurlyBrackets * AMOUNT_OF_SPACES];

        for (int i = 0; i < amountOfCurlyBrackets * AMOUNT_OF_SPACES; i++) {
            str[i] = ' ';
        }

        return str;

    }
}
