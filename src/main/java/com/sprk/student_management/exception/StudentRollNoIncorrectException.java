package com.sprk.student_management.exception;

import org.springframework.http.HttpStatus;

public class StudentRollNoIncorrectException extends StudentException{

    public StudentRollNoIncorrectException(String message, HttpStatus statusCode) {
        super(message, statusCode);
    }
}
