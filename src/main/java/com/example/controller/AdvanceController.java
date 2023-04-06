package com.example.controller;


import com.example.exp.AppBadRequestException;
import com.example.exp.PhoneAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdvanceController {
    @ExceptionHandler({AppBadRequestException.class, PhoneAlreadyExistsException.class})
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
