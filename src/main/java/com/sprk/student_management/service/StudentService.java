package com.sprk.student_management.service;

import com.sprk.student_management.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto saveStudent(StudentDto studentDto);

    List<StudentDto> getAllStudentLists();

    StudentDto getStudentByRollNo(String rollNo);

    void deleteStudent(StudentDto studentDto);
}
