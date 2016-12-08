package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.Action;

public interface IState {

    public IState getNextState(final IState currentState, final char c);

    public Action getAction();

    public void setSymbol(final char a);
}
