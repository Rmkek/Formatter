package com.rmk.formatter.formatter;

import com.rmk.formatter.exception.FormatterException;
import com.rmk.formatter.formatter.command.Action;
import com.rmk.formatter.formatter.state.State;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.writer.IWriter;

import static com.rmk.formatter.formatter.state.State.getNextState;

/**
 * IFormatter implementation.
 */
public class Formatter implements IFormatter {
    private State currentState;

    @Override
    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        try {
            char c = (char) reader.readChar();
            currentState = new State(c);

            while (reader.hasChars()) {
                Action action = currentState.getAction();
                action.execute(writer);
                currentState = getNextState(currentState, c);
            }

        } catch (Exception ex) {
            throw new FormatterException(ex);
        }
    }
}
