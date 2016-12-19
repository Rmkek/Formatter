package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;

/**
 * Action for writing one char.
 */
public class DefaultAction implements IAction {

    private static char tmp;

    /**
     * Action constructor.
     * @param ch that will be written.
     */
    public DefaultAction(final char ch) {
        tmp = ch;
    }

    @Override
    public void execute(final IWriter writer) {
        writer.writeChar(tmp);
    }

}
