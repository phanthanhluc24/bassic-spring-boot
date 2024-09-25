package com.example.SpringBoot.exception;

import com.example.SpringBoot.dto.ApiResponse;
import com.example.SpringBoot.modals.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlingApiException(ApiException exception){
        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus()).body(ApiResponse.<Student>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build());
    }


}
