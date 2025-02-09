package com.sprk.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentDto {


    private int rollNo;

    @NotBlank(message = "first name should contain atleast one character")
    private String firstName;

    @NotBlank(message = "last name should contain atleast one character")
    private String lastName;

    @NotBlank(message = "phone number cannot be empty")
    @Pattern(regexp = "^\\+?\\d{1,3}(\\s\\d{1,5})?(\\s\\d+)+$", message = "Please enter phone number in correct format")
    private String phone;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "Please specify correct email [johndoe@gmail.com]")
    private String email;

    private String gender;
}

