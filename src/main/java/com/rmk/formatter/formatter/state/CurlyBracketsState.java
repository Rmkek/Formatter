package com.rmk.formatter.formatter.state;

import com.rmk.formatter.formatter.command.Action;

import java.util.HashMap;

public class CurlyBracketsState implements IState {
    private static final int AMOUNT_OF_SPACES = 4;
    private static int amountOfCurlyBrackets = 0;
    private char symbol;

    private HashMap<Character, IState> stateHashMap = new HashMap<>();


    @Override
    public Action getAction() {
        amountOfCurlyBrackets++;
        return new Action(evalBracketsSpaces());
    }

    private static char[] evalBracketsSpaces() {
        char[] str = new char[amountOfCurlyBrackets * AMOUNT_OF_SPACES + 1];
        str[0] = '\n';
        for (int i = 0; i < amountOfCurlyBrackets * AMOUNT_OF_SPACES; i++) {
            str[i] = ' ';
        }
        return str;
    }

    @Override
    public IState getNextState(IState currentState, char c) {
        IState state = stateHashMap.getOrDefault(c, new DefaultState());
        state.setSymbol(c);
        return state;
    }

    @Override
    public void setSymbol(char a) {
        symbol = a;

        stateHashMap.put('\"', new CommentState());
        stateHashMap.put('{', new CurlyBracketsState());
        stateHashMap.put('\\', new EscapeState());
        stateHashMap.put('\'', new CommentState());
    }
}
