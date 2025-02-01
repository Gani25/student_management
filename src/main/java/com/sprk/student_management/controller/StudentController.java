package com.sprk.student_management.controller;

import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sprk")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/students")
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudentDto = studentService.saveStudent(studentDto);
        return savedStudentDto;
    }
}
