package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.DefaultAction;
import com.rmk.formatter.formatter.command.IAction;

import java.util.HashMap;

/**
 * State for default character that will be just written into output.
 */
public class DefaultState implements IState {
    private char symbol;
    private HashMap<Character, IState> stateHashMap = new HashMap<>();


    @Override
    public IState getNextState(final IState currentState, final char c) {
        IState state = stateHashMap.getOrDefault(c, new DefaultState());
        state.setSymbol(c);
        return state;
    }


    @Override
    public void setSymbol(final char a) {
        stateHashMap.put('\"', new CommentState());
        stateHashMap.put('{', new CurlyBracketsState());
        stateHashMap.put('\\', new EscapeState());
        stateHashMap.put('\'', new CommentState());

        symbol = a;
    }

    @Override
    public IAction getAction() {
        return new DefaultAction(symbol);
    }
}
