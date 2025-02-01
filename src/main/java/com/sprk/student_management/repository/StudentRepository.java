package com.sprk.student_management.repository;

import com.sprk.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByEmailOrPhone(String email, String phone);
}
