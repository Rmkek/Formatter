package com.rmk.formatter.formatter;

import com.rmk.formatter.formatter.state.*;

import java.util.HashMap;

public class StateManager {

    private static HashMap<Character, IState> stateMap = new HashMap<>();

    static {
        stateMap.put('\'', new CommentState());
        stateMap.put('\"', new CommentState());
        stateMap.put('{', new CurlyBracketsState());
        stateMap.put('\\', new EscapeState());
    }

    public IState nextState(final char symbol) {
        IState state = stateMap.getOrDefault(symbol, new DefaultState());
        state.setSymbol(symbol);
        return state;
    }

    public IState getNextState(final IState curState, final char symbol) {
        IState state = stateMap.getOrDefault(symbol, new DefaultState());
        state.setSymbol(symbol);
        return state;
    }

}
