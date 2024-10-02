package br.com.challenge.loan.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ValidationError> validation(
            MethodArgumentNotValidException e, HttpServletRequest request){

        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setError(e.getMessage());
        error.setPath(request.getRequestURI());
        error.setMessage("Validation fields error!");

        for(FieldError fieldError : e.getBindingResult().getFieldErrors()){
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }
}
