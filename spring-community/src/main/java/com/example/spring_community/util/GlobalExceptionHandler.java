package com.example.spring_community.util;

import com.example.spring_community.dto.common.CommonApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message = e.getBindingResult().getAllErrors().
                getFirst().getDefaultMessage();
        CommonApiResponse<Object> response = new CommonApiResponse<>("invalid_request", message, null);
        return ResponseEntity.status(400).body(response);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CommonApiResponse<Object>> NoSuchElementException(NoSuchElementException e){
        String message = e.getMessage();
        CommonApiResponse<Object> response = new CommonApiResponse<>("Not Found", message, null);
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonApiResponse<Object>> handleException(Exception e){
        String message = e.getMessage();
        CommonApiResponse<Object> response = new CommonApiResponse<>("internal_server_error", message, null);
        return ResponseEntity.status(500).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CommonApiResponse<Object>> handleIllegalArgumentException(IllegalArgumentException e){
        String message = e.getMessage();
        CommonApiResponse<Object> response = new CommonApiResponse<>("illegal_argument", message, null);
        return ResponseEntity.status(400).body(response);
    }
}
