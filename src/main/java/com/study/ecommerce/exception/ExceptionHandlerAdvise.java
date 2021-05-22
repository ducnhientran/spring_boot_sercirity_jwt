package com.study.ecommerce.exception;

import com.study.ecommerce.model.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvise {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseData> handleRuntimeException(RuntimeException ex) {
        ResponseData responseData = ResponseData.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.badRequest().body(responseData);
    }
}
