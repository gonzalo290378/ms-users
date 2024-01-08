package com.bench.msusers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DniNotFoundException extends RuntimeException{
    public DniNotFoundException(String message){
        super(message);
    }
}

