package com.example.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperadorInvalidoException extends Exception {
    public OperadorInvalidoException() {
        super();
    }

    public OperadorInvalidoException(String msg) {
        super(msg);
    }

    public OperadorInvalidoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
