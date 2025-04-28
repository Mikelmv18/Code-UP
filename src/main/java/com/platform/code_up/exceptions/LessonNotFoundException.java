package com.platform.code_up.exceptions;

public class LessonNotFoundException extends Exception {

    public LessonNotFoundException() {
        super("Lesson not found");
    }
}
