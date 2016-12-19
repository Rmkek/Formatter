package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.CurlyBracketsAction;
import com.rmk.formatter.formatter.command.IAction;

import java.util.HashMap;

/**
 * State for curly brackets character.
 */
public class CurlyBracketsState implements IState {
    private char symbol;

    private HashMap<Character, IState> stateHashMap = new HashMap<>();

    @Override
    public IAction getAction() {
        return new CurlyBracketsAction(symbol);
    }

    @Override
    public IState getNextState(final IState currentState, final char c) {
        IState state = stateHashMap.getOrDefault(c, new DefaultState());
        state.setSymbol(c);
        return state;
    }

    @Override
    public void setSymbol(final char a) {
        symbol = a;

        stateHashMap.put('\"', new CommentState());
        stateHashMap.put('{', new CurlyBracketsState());
        stateHashMap.put('\\', new EscapeState());
        stateHashMap.put('\'', new CommentState());
    }
}
