package com.example.calculadora.exception.handler;

import com.example.calculadora.exception.OperadorInvalidoException;
import com.example.calculadora.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = OperadorInvalidoException.class)
    public ResponseEntity<ErrorResponse> invalidURI(OperadorInvalidoException e) {
        ErrorResponse errorResponse = new ErrorResponse(400, e.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
