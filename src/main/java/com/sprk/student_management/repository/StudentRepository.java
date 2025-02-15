package com.sprk.student_management.repository;

import com.sprk.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

//    Optional<Student> findByEmailOrPhone(String email, String phone);

    // JPQL (Jakarta Persistence Query Language )
    @Query("SELECT s FROM Student s WHERE (s.email = :email OR s.phone = :phone) AND s.rollNo != :rollNo")
    List<Student> findByEmailOrPhoneAndNotByRollNo(@Param("email") String email, @Param("phone") String phone, @Param("rollNo") int rollNo);

}
