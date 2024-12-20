package com.chat_app.backend_chat_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chat_app.backend_chat_app.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
      String message = exception.getMessage();
      ApiResponse apiResponse = new ApiResponse(message, false);
      return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
   }
}
