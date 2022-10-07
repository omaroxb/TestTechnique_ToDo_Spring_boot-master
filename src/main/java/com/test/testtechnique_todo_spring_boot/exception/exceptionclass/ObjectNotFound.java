package com.test.testtechnique_todo_spring_boot.exception.exceptionclass;

public class ObjectNotFound extends RuntimeException{
    public ObjectNotFound(String message) {
        super(message);
    }
}
