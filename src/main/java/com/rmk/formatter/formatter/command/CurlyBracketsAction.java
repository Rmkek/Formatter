package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Action for curly brackets in code.
 */
public class CurlyBracketsAction implements IAction {

    private char aChar;
    private int amountOfBrackets = 1;
    private final int amountOfSpaces = 4;

    /**
     * Constructor for obtaining symbol.
     * @param c symbol that will be written.
     */
    public CurlyBracketsAction(final char c) {
        aChar = c;
    }

    @Override
    public void execute(final IWriter writer) {
        amountOfBrackets++;

        writeSpaces(writer);
        writer.writeChar(aChar);
    }

    private void writeSpaces(final IWriter writer) {
        for (int i = 0; i < amountOfBrackets; i++) {
            for (int j = 0; j < amountOfSpaces; j++) {
                writer.writeChar(' ');
            }
        }
    }
}
