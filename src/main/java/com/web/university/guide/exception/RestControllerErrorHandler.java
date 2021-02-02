package com.web.university.guide.exception;

import com.web.university.guide.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestControllerErrorHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<BaseResponse> handleNotFound(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>(new BaseResponse().addErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
