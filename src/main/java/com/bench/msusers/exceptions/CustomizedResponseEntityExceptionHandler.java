package com.bench.msusers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception e, WebRequest webRequest) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception e, WebRequest webRequest) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(DniNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleDniNotFoundException(Exception e, WebRequest webRequest) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUsernameNotFoundException(Exception e, WebRequest webRequest) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

}
