package br.com.scienceblog.controllers.exceptions.handler;

import br.com.scienceblog.controllers.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAll (Exception ex) {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                ex.getMessage());
        response.getErrors().add(ex.getLocalizedMessage());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                ex.getMessage());
        response.getErrors().add(ex.getMessage());

        return new ResponseEntity<>(response, response.getStatus());
    }
}
