package com.codestates.section4solo.exception;

import lombok.Getter;

public enum ExceptionCode {
    TODO_NOT_FOUND(404, "ToDo not found"),
    TODO_EXISTS(409, "ToDo exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }
}
