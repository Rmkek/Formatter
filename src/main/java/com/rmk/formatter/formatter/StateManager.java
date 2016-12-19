package com.rmk.formatter.formatter;

import com.rmk.formatter.formatter.state.CurlyBracketsState;
import com.rmk.formatter.formatter.state.EscapeState;
import com.rmk.formatter.formatter.state.IState;
import com.rmk.formatter.formatter.state.CommentState;
import com.rmk.formatter.formatter.state.DefaultState;

import java.util.HashMap;

/**
 * Class that manages first state.
 */
public class StateManager {

    private static HashMap<Character, IState> stateMap = new HashMap<>();

    static {
        stateMap.put('\'', new CommentState());
        stateMap.put('\"', new CommentState());
        stateMap.put('{', new CurlyBracketsState());
        stateMap.put('\\', new EscapeState());
    }


    /**
     * Next state that will be used by app.
     * @param symbol by which next state will be resolver.
     * @return IState
     */
    public IState nextState(final char symbol) {
        IState state = stateMap.getOrDefault(symbol, new DefaultState());
        state.setSymbol(symbol);
        return state;
    }


    /**
     * Next state of the app using currentState and symbol.
     * @param curState IState current state.
     * @param symbol symbol that will be used in next state.
     * @return IState.
     */
    public IState getNextState(final IState curState, final char symbol) {
        IState state = stateMap.getOrDefault(symbol, new DefaultState());
        state.setSymbol(symbol);
        return state;
    }

}
