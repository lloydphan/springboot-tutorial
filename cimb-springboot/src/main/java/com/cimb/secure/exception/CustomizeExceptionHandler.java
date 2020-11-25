package com.cimb.secure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotDefineException.class)
    public ResponseEntity<CustomizeErrorDetail> Exception(NotDefineException re, WebRequest rq) {
        CustomizeErrorDetail errorDetail = new CustomizeErrorDetail(new Date(), re.getMessage(), rq.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomizeErrorDetail> handleResourceNotFoundException(ResourceNotFoundException re, WebRequest rq) {
        CustomizeErrorDetail errorDetail = new CustomizeErrorDetail(new Date(), re.getMessage(), rq.getDescription(false));
        return new ResponseEntity<> (errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ElementNullException.class)
    public ResponseEntity<CustomizeErrorDetail> handleElementNullException(ElementNullException re, WebRequest rq) {
        CustomizeErrorDetail errorDetail = new CustomizeErrorDetail(new Date(), re.getMessage(), rq.getDescription(false));
        return new ResponseEntity<> (errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataFormatException.class)
    public ResponseEntity<CustomizeErrorDetail> handleDataFormatException(DataFormatException re, WebRequest rq) {
        CustomizeErrorDetail errorDetail = new CustomizeErrorDetail(new Date(), re.getMessage(), rq.getDescription(false));
        return new ResponseEntity<> (errorDetail, HttpStatus.NOT_FOUND);
    }

}
