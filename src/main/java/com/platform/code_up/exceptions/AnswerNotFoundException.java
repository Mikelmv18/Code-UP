package com.platform.code_up.exceptions;

public class AnswerNotFoundException extends Exception {



    public AnswerNotFoundException(String message) {
    }
    public AnswerNotFoundException() {
        super("Answer not found");
    }
}
