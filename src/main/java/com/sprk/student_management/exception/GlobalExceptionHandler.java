package com.sprk.student_management.exception;

import com.sprk.student_management.dto.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorResponseDto> handleStudentException(StudentException ex, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setApiPath(request.getDescription(false));
        errorResponseDto.setStatusCode(ex.getStatusCode());
        errorResponseDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, ex.getStatusCode());



    }
}
