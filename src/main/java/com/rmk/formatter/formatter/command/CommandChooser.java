package com.rmk.formatter.formatter.command;

import com.rmk.formatter.exception.FormatterException;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.writer.IWriter;

/**
 * Class for choosing which command will be executed.
 */
public class CommandChooser {
    private static final int NULL_CHAR = 65535;
    private static final int AMOUNT_OF_SPACES = 4;

    /**
     * Class that returns command by given reader and writer.
     * @param reader any IReader implementation.
     * @param writer any IWriter implementation.
     * @throws FormatterException when any exception occurs
     */
    public void getCommand(final IReader reader, final IWriter writer) throws FormatterException {

        int curlyBracketsAmount = 0;
        int charsRead = 1;

        char previousSymbol = NULL_CHAR;
        char currentSymbol = NULL_CHAR;
        char nextSymbol = NULL_CHAR;

        try {


            while (reader.hasChars()) {
                currentSymbol = reader.readChar();

                if (currentSymbol == '\'' || currentSymbol == '\"') { //check for '
                    nextSymbol = reader.readChar();
                    writer.writeChar(currentSymbol);
                    writer.writeChar(nextSymbol);

                    while (nextSymbol != '\"' || nextSymbol != '\'') {
                        nextSymbol = reader.readChar();
                        writer.writeChar(nextSymbol);
                    }
//                    lastSymbol = tmpChars[1];
                    continue;
                }

                if (currentSymbol == '/') { //check for comment
                    nextSymbol = reader.readChar();
                    writer.writeChar(currentSymbol);
                    writer.writeChar(nextSymbol);

                    char ch;
                    char ch2;

                    if (nextSymbol == '*') {
                        ch = reader.readChar();
                        ch2 = NULL_CHAR;
                        while (ch != '*' && ch2 != '/') {
                            ch = reader.readChar();
                            ch2 = reader.readChar();
                            writer.writeChar(ch);
                            writer.writeChar(ch2);
                        }
//                        lastSymbol = ch2;
                        continue;
                    }

                    if (nextSymbol == '/') {
                        do {
                            ch = reader.readChar();
                            writer.writeChar(ch);
                        } while (ch != '\n' || ch == '\u0000');
//                        lastSymbol = ch;
                        continue;
                    }
                }

                if (previousSymbol == NULL_CHAR) {
                    previousSymbol = currentSymbol;
                }

                if (currentSymbol == '}') {
                    --curlyBracketsAmount;
                }

                if (currentSymbol == '\n' && previousSymbol != ';' && previousSymbol != '/') {
                    writer.writeChar(';');
                }

                if (curlyBracketsAmount > 0 && previousSymbol == '\n') {
                    writeSpaces(evalBracketsSpaces(curlyBracketsAmount), writer);
                }

                if (currentSymbol == '{') {
                    ++curlyBracketsAmount;
                    nextSymbol = reader.readChar();

                    if (nextSymbol != '\n') {
                        writer.writeChar(currentSymbol); // '{'
                        writer.writeChar('\n');
                        writeSpaces(evalBracketsSpaces(curlyBracketsAmount), writer);
                        writer.writeChar(nextSymbol);
                    } else {
                        writer.writeChar(currentSymbol); // '{'
                        writeSpaces(evalBracketsSpaces(curlyBracketsAmount), writer);

                    }
                    continue;
                }

                switch (charsRead) {
                    case 1:
                        writer.writeChar(previousSymbol);
                        break;
                    case 2:
                        writer.writeChar(previousSymbol);
                        writer.writeChar(currentSymbol);
                        break;
                    case 3: //CheckStyle said that '3' is magic number?!
                        // Guess i'll fix it with constant, it will make more readable and obvious code.
                        writer.writeChar(previousSymbol);
                        writer.writeChar(currentSymbol);
                        writer.writeChar(nextSymbol);
                        break;
                    default:
                        break;
                }
                previousSymbol = currentSymbol;
            }

            if (curlyBracketsAmount >= 1) {
                writer.writeChar('}');
            }

            writer.close();
        } catch (Exception ex) {
            throw new FormatterException(ex);
    }
    }
    private char[] evalBracketsSpaces(final int amountOfCurlyBrackets) {
        char[] str = new char[amountOfCurlyBrackets * AMOUNT_OF_SPACES];
        for (int i = 0; i < amountOfCurlyBrackets * AMOUNT_OF_SPACES; i++) {
            str[i] = ' ';
        }
        return str;
    }

    private void writeSpaces(final char[] spaces, final IWriter writer) {
        for (char ch: spaces) {
            writer.writeChar(ch);
        }
    }

}
