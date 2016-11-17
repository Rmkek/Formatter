package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Command for inserting spaces before code.
 */
public class CommandInsertSpaces implements ICommand {

    private static final int AMOUNT_OF_SPACES = 4;
    private int curlyBracketsAmount = 0;

    /**
     * Constructor for command class
     * @param curlyBracketsAmount how many brackets was opened.
     */
    CommandInsertSpaces(final int curlyBracketsAmount) {
        this.curlyBracketsAmount = curlyBracketsAmount;
    }

    @Override
    public void execute(final IWriter writer) {
        char[] chars = evalBracketsSpaces(curlyBracketsAmount);

        for (char ch: chars) {
            writer.writeChar(ch);
        }
    }

    private char[] evalBracketsSpaces(final int amountOfCurlyBrackets) {
        char[] str = new char[amountOfCurlyBrackets * AMOUNT_OF_SPACES];
        for (int i = 0; i < amountOfCurlyBrackets * AMOUNT_OF_SPACES; i++) {
            str[i] = ' ';
        }
        return str;

    }
}
