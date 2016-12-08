package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.Action;

import java.util.HashMap;

public class DefaultState implements IState {
    private char symbol;
    private HashMap<Character, IState> stateHashMap = new HashMap<>();


    @Override
    public IState getNextState(IState currentState, char c) {
        IState state = stateHashMap.getOrDefault(c, new DefaultState());
        state.setSymbol(c);
        return state;
    }

    public void setSymbol(final char a) {
        stateHashMap.put('\"', new CommentState());
        stateHashMap.put('{', new CurlyBracketsState());
        stateHashMap.put('\\', new EscapeState());
        stateHashMap.put('\'', new CommentState());

        symbol = a;
    }

    @Override
    public Action getAction() {
        char[] arr = {symbol};
        return new Action(arr);
    }
}
