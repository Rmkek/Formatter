package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Class for choosing which command will be executed.
 */
public class Action {
    private static final int NULL_CHAR = 65535;
    private static final int AMOUNT_OF_SPACES = 4;

    private static char[] tmp;

    /**
     * Action constructor.
     * @param action string that will be written.
     */
    public Action(final String action) {
        tmp = action.toCharArray();
    }

    /**
     * Executes code
     * @param writer that will be written to
     */
    public void execute(final IWriter writer) {
        for (final char each : tmp) {
            writer.writeChar(each);
        }
    }

    private static char[] evalBracketsSpaces(final int amountOfCurlyBrackets) {
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
