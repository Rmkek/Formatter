package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.IAction;

/**
 * State interface
 */
public interface IState {

    /**
     * Method for getting next state by using current state and next char.
     * @param currentState current state.
     * @param c next char
     * @return new IState
     */
    IState getNextState(IState currentState, char c);

    /**
     * Action that will be written to output.
     * @return Action.
     */
    IAction getAction();

    /**
     * Sets current symbol.
     * @param a symbol.
     */
    void setSymbol(char a);
}
