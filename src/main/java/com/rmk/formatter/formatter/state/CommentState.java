package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.CommentAction;
import com.rmk.formatter.formatter.command.IAction;

import java.util.HashMap;

/**
 * Class for comments in code.
 */
public class CommentState implements IState {

    private static char symbol;
    private static char commentSymbol;
    private static boolean commentSymbolSet = false;

    private static HashMap<Character, IState> stateHashMap = new HashMap<>();

    @Override
    public void setSymbol(final char a) {
        if (!commentSymbolSet) {
            commentSymbol = a;
            commentSymbolSet = true;
        }

        stateHashMap.put('\\', new EscapeState());
        stateHashMap.put(a, new DefaultState());

        symbol = a;
    }

    @Override
    public IAction getAction() {
        return new CommentAction(symbol);
    }

    /**
     * Returns next state for commentState.
     * @param currentState currentState.
     * @param a character that will be used.
     * @return state.
     */
    public IState getNextState(final IState currentState, final char a) {
        IState state = stateHashMap.getOrDefault(a, new DefaultState());
        state.setSymbol(a);
        return state;
    }
}
