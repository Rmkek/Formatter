package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.Action;

/**
 * Class for escape characters.
 */
public class EscapeState extends State {

    private final char symbol;


    /**
     * Constructor for EscapeState.
     * @param a char that will be used.
     */
    EscapeState(final char a) {
        super(a);
        symbol = a;
    }

    /**
     * Method for getting action with character
     * @param a character that will be used
     * @return Action.
     */
    public Action getAction(final char a) {
        return new Action(String.valueOf(a));
    }

    /**
     * Method for getting next state.
     * @param currentState current state of formatter.
     * @param a current character.
     * @return new CommentState
     */
    public static State getNextState(final State currentState, final char a) {
        return new CommentState(a);
    }

}
