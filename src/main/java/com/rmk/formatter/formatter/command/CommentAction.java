package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Action for comments in code.
 */
public class CommentAction implements IAction {

    private char ch;

    /**
     * Constructor that obtains char.
     * @param c symbol that will be written.
     */
    public CommentAction(final char c) {
        ch = c;
    }

    @Override
    public void execute(final IWriter writer) {
        writer.writeChar(ch);
    }
}
