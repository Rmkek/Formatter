package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.Action;

/**
 * Class for comments in code.
 */
public class CommentState extends State {

    private static char symbol;
    private static char commentSymbol;
    private static boolean commentSymbolSet = false;

    /**
     * Public constructor for comment class.
     * @param a character that will be used.
     */
    public CommentState(final char a) {
        super(a);
        if (!commentSymbolSet) {
            commentSymbol = a;
            commentSymbolSet = true;
        }
        symbol = a;
    }

    @Override
    public Action getAction() {
        return new Action(String.valueOf(symbol));
    }

    /**
     * Returns next state for commentState.
     * @param currentState currentState.
     * @param a character that will be used.
     * @return state.
     */
    public static State getNextState(final State currentState, final char a) {
        if (a == '\\') {
            return new EscapeState(a);
        }
        if (a == commentSymbol) {
            return new State(a);
        }

        return new CommentState(a);
    }
}
