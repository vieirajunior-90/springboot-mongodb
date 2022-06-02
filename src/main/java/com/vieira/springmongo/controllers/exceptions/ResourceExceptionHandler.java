package com.vieira.springmongo.controllers.exceptions;

import com.vieira.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        var timestamp = LocalDateTime.now();
        var status = HttpStatus.NOT_FOUND.value();
        var error = HttpStatus.NOT_FOUND.getReasonPhrase();
        var message = e.getMessage();
        var path = request.getRequestURI();

        StandardError err = new StandardError(timestamp, status, error, message, path);

        return ResponseEntity.status(status).body(err);
    }
}
