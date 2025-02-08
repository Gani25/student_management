package com.sprk.student_management.controller;

import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtoList =  studentService.getAllStudentLists();

        return studentDtoList;
    }

    // Get student by roll no
    @GetMapping("/students/{rollNo}")
    public ResponseEntity<?> getAllStudents(@PathVariable int rollNo) {
        StudentDto studentDto =  studentService.getStudentByRollNo(rollNo);

        if(studentDto == null) {
        return new ResponseEntity<>("Student Not Found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }
}
