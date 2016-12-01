package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.Action;

import java.util.HashMap;

/**
 * State main class.
 */
public class State {

    private static char symbol = 65535;

    private static int curlyBracketsAmount = 0;

    public static boolean newLine = false;

    private static HashMap<Character, Action> map = new HashMap<>();

    static {
        map.put('{', new Action("\n    "));
        map.put('}', new Action("\n"));
    }

    /**
     * State constructor.
     * @param a char.
     */
    public State(final char a) {
        symbol = a;
    }

    /**
     * Method for getting next state.
     * @param currentState current state class.
     * @param c character.
     * @return next state
     */
    public static State getNextState(final State currentState, final char c) {
        symbol = c;


        if (symbol == '\'') {
            return new CommentState(c);
        }

        if (symbol == '\"') {
            return new CommentState(c);
        }

        if (symbol == '{') {
            curlyBracketsAmount++;
        }

        return new EscapeState(c);
    }


    public Action getAction() {
        return map.getOrDefault(symbol, new Action(String.valueOf(symbol)));
    }

}
