package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.EscapeAction;
import com.rmk.formatter.formatter.command.IAction;

/**
 * Class for escape characters.
 */
public class EscapeState implements IState {

    private char symbol;


    public void setSymbol(final char a) {
        symbol = a;
    }

    /**
     * Method for getting action with character
     * @return Action.
     */
    public IAction getAction() {
        return new EscapeAction(symbol);
    }

    /**
     * Method for getting next state.
     * @param currentState current state of formatter.
     * @param a current character.
     * @return new CommentState
     */
    public IState getNextState(final IState currentState, final char a) {
        IState state = new CommentState();
        state.setSymbol(a);
        return state;
    }

}
