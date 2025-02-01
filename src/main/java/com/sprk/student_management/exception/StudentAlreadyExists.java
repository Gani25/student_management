package com.sprk.student_management.exception;

import org.springframework.http.HttpStatus;


public class StudentAlreadyExists extends StudentException{

    public StudentAlreadyExists(String message, HttpStatus statusCode) {
        super(message, statusCode);
    }
}
