package com.test.testtechnique_todo_spring_boot.exception;

import com.test.testtechnique_todo_spring_boot.enumeration.Behavior;
import com.test.testtechnique_todo_spring_boot.exception.exceptionclass.ObjectNotFound;
import com.test.testtechnique_todo_spring_boot.util.utilclass.ResponseMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppException {
    @ExceptionHandler(value = ObjectNotFound.class)
    public ResponseEntity<ResponseMessage> handelUserNotFoundException(ObjectNotFound exception, WebRequest request){
        String errorMessageDescription = exception.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = exception.toString();
        ResponseMessage errorMessage = new ResponseMessage(errorMessageDescription, Behavior.ERROR);
        return new ResponseEntity<ResponseMessage>(
                errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND
        );

    }
}
