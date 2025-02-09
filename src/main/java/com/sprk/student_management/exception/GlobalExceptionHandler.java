package com.sprk.student_management.exception;

import com.sprk.student_management.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();

        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String validationErrorMsg = error.getDefaultMessage();

            validationErrors.put(fieldName, validationErrorMsg);
        });

        ErrorResponseDto<Map> errorResponseDTO = new ErrorResponseDto<>();

        errorResponseDTO.setApiPath(request.getDescription(false));
        errorResponseDTO.setTimestamp(LocalDateTime.now());
        errorResponseDTO.setMessage(validationErrors);
        errorResponseDTO.setStatusCode(HttpStatus.valueOf(status.value()));

        return new ResponseEntity<>(errorResponseDTO, headers, status);
    }

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorResponseDto> handleStudentException(StudentException ex, WebRequest request) {
        ErrorResponseDto<String> errorResponseDto = new ErrorResponseDto<>();

        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setApiPath(request.getDescription(false));
        errorResponseDto.setStatusCode(ex.getStatusCode());
        errorResponseDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, ex.getStatusCode());


    }
}
