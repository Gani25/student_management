package com.sprk.student_management.controller;

import com.sprk.student_management.constants.StudentConstants;
import com.sprk.student_management.dto.ResponseDto;
import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.entity.Student;
import com.sprk.student_management.service.StudentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseDto<StudentDto>> addStudent(@Valid @RequestBody StudentDto studentDto) {
        StudentDto savedStudentDto = studentService.saveStudent(studentDto);

        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatusCode(HttpStatus.valueOf(Integer.parseInt(StudentConstants.STATUS_201)));
        responseDto.setMessage(StudentConstants.MESSAGE_201);
        responseDto.setData(savedStudentDto);
        return new ResponseEntity<>(responseDto, responseDto.getStatusCode());
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseDto<List<StudentDto>>>  getAllStudents() {
        List<StudentDto> studentDtoList =  studentService.getAllStudentLists();
        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatusCode(HttpStatus.valueOf(Integer.parseInt(StudentConstants.STATUS_202)));
        responseDto.setMessage(StudentConstants.MESSAGE_202);
        responseDto.setData(studentDtoList);

        return new ResponseEntity<>(responseDto, responseDto.getStatusCode());
    }

    // Get student by roll no
    @GetMapping("/students/{rollNo}")
    public ResponseEntity<ResponseDto<?>> getAllStudents(@PathVariable int rollNo) {
        StudentDto studentDto =  studentService.getStudentByRollNo(rollNo);
        ResponseDto responseDto = new ResponseDto();
        if(studentDto == null) {
            responseDto.setStatusCode(HttpStatus.valueOf(Integer.parseInt(StudentConstants.STATUS_400)));
            responseDto.setMessage(StudentConstants.MESSAGE_NOT_FOUND_400);
            responseDto.setData(null);
        return new ResponseEntity<>(responseDto, responseDto.getStatusCode());
        }


        responseDto.setStatusCode(HttpStatus.valueOf(Integer.parseInt(StudentConstants.STATUS_202)));
        responseDto.setMessage(StudentConstants.MESSAGE_202);
        responseDto.setData(studentDto);

        return new ResponseEntity<>(responseDto, responseDto.getStatusCode());

    }
}
