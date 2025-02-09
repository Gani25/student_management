package com.sprk.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto<T> {
    private String apiPath;
    private HttpStatus statusCode;
    private T message;
    private LocalDateTime timestamp;
}
