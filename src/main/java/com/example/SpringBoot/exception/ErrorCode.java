package com.example.SpringBoot.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public enum ErrorCode {
    STUDENT_NOT_EXIT(40401,"student not found",HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_FOUND(40402,"eployee not found",HttpStatus.NOT_FOUND)
    ;
    Integer code;
    String message;
    HttpStatus status;


}
