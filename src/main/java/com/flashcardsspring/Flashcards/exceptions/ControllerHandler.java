package com.flashcardsspring.Flashcards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handlerValidationException(MethodArgumentNotValidException ex) {
        var status = HttpStatus.BAD_REQUEST;
        var errorMessages = new ArrayList<String>();
        var fieldErrors = ex.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            var msgError = "O campo " + e.getField() + " " + e.getDefaultMessage();
            errorMessages.add(msgError);
        });

        return ResponseEntity.status(status).body(new ErrorMessage(status.value(), errorMessages));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorMessage> handlerNotFoundException(ResponseStatusException ex) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new ErrorMessage(status.value(), "Entidade não encontrada"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handlerException(ResponseStatusException ex) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(new ErrorMessage(status.value(), "Tivemos um problema com o servidor"));
    }
}
