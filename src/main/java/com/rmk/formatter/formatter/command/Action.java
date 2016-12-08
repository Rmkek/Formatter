package com.rmk.formatter.formatter.command;

import com.rmk.formatter.writer.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for choosing which command will be executed.
 */
public class Action {
    private static char[] tmp;
    final static Logger logger = LoggerFactory.getLogger(Action.class);


    /**
     * Action constructor.
     * @param action string that will be written.
     */
    public Action(final char[] action) {
        tmp = action;
    }

    /**
     * Executes code
     * @param writer that will be written to
     */
    public void execute(final IWriter writer) {
        for (final char each : tmp) {
            logger.info("Writing into output, writer content: " + each);
            writer.writeChar(each);
        }
    }



    private void writeSpaces(final char[] spaces, final IWriter writer) {
        for (char ch: spaces) {
            writer.writeChar(ch);
        }
    }

}
