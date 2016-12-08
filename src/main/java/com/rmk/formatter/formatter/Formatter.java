package com.rmk.formatter.formatter;

import com.rmk.formatter.exception.FormatterException;
import com.rmk.formatter.formatter.command.Action;
import com.rmk.formatter.formatter.state.IState;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.writer.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * IFormatter implementation.
 */
public class Formatter implements IFormatter {
    private IState currentState;
    final static Logger logger = LoggerFactory.getLogger(Formatter.class);

    @Override
    public void format(final IReader reader, final IWriter writer, final StateManager stateManager) throws FormatterException {
        try {
            while (reader.hasChars()) {
                char c = (char) reader.readChar();
                logger.info("Working with char: " + c);
                currentState = stateManager.nextState(c);
                logger.info("Current state: " + currentState.getClass());
                Action action = currentState.getAction();
                action.execute(writer);
                currentState = stateManager.getNextState(currentState, c);
            }
            writer.close();
        } catch (Exception ex) {
            throw new FormatterException(ex);
        }
    }
}
