package com.rmk.formatter.formatter;

import com.rmk.formatter.exception.FormatterException;
import com.rmk.formatter.formatter.command.IAction;
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

    /**
     * Logger instance.
     */
    static final Logger LOGGER = LoggerFactory.getLogger(Formatter.class);

    @Override
    public void format(final IReader reader, final IWriter writer, final StateManager stateManager) throws FormatterException {
        try {
            while (reader.hasChars()) {
                char c = (char) reader.readChar();
                currentState = stateManager.nextState(c);
                IAction action = currentState.getAction();
                action.execute(writer);
                currentState = stateManager.getNextState(currentState, c);
            }
            writer.close();
        } catch (Exception ex) {
            throw new FormatterException(ex);
        }
    }
}
