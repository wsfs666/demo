package com.example.employee.exception;

//            *      2. @ControllerAdvice + @ExceptionHandler -> Exception.class -> internal server error
//     *      3. @ControllerAdvice + common response

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity globalExceptionHandler(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
