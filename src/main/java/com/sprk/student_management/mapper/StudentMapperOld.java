package com.sprk.student_management.mapper;

import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.entity.Student;

public final class StudentMapperOld {

    public static final Student mapStudentDtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setGender(studentDto.getGender());
        return student;
    }

    public static final StudentDto mapStudentToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhone(student.getPhone());
        studentDto.setGender(student.getGender());
        return studentDto;
    }

}
