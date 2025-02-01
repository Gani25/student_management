package com.sprk.student_management.mapper;

import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student mapStudentDtoToStudent(StudentDto studentDto);
    StudentDto mapStudentToStudentDto(Student student);
}
