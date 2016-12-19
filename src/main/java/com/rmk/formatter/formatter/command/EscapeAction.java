package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Action for escape symbol.
 */
public class EscapeAction implements IAction {
    private char ch;

    /**
     * Constructor for obtaining current symbol.
     * @param ch symbol that will be written.
     */
    public EscapeAction(final char ch) {
        this.ch = ch;
    }

    @Override
    public void execute(final IWriter writer) {
        writer.writeChar(ch);
    }
}
