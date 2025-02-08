package com.sprk.student_management.service.impl;

import com.sprk.student_management.constants.StudentConstants;
import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.entity.Student;
import com.sprk.student_management.exception.StudentAlreadyExists;
import com.sprk.student_management.mapper.StudentMapper;
import com.sprk.student_management.mapper.StudentMapperOld;
import com.sprk.student_management.repository.StudentRepository;
import com.sprk.student_management.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        // Convert DTO to Entity
        // Mapper
        Student student = studentMapper.mapStudentDtoToStudent(studentDto);
        // Find Student By Email Or Phone If exists thorw some error
        Optional<Student> dbStudent = studentRepository.findByEmailOrPhone(student.getEmail(),student.getPhone());
        if(dbStudent.isPresent()){
            throw new StudentAlreadyExists(StudentConstants.MESSAGE_400, HttpStatus.valueOf(Integer.parseInt(StudentConstants.STATUS_400)));
        }
        Student savedStudent = studentRepository.save(student);
        return studentMapper.mapStudentToStudentDto(savedStudent);
    }

    @Override
    public List<StudentDto> getAllStudentLists() {
        List<Student> students = studentRepository.findAll();

        List<StudentDto> studentDtos = students
                .stream()
                .map(student -> studentMapper.mapStudentToStudentDto(student))
                .toList();

        return studentDtos;

    }

    @Override
    public StudentDto getStudentByRollNo(int rollNo) {
        Student student = studentRepository.findById(rollNo).orElse(null);

        return studentMapper.mapStudentToStudentDto(student);
    }

}
