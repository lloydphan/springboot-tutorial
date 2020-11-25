package com.cimb.secure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotDefineException extends RuntimeException {

    public NotDefineException() {
        super();
    }

    public NotDefineException(String message) {
        super(message);
    }
}
