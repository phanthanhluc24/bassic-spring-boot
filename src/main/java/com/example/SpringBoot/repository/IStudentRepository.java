package com.example.SpringBoot.repository;

import com.example.SpringBoot.modals.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
//    List<Student> findAll();
//    Optional<Student> findById(Long id);
//    Student save(Student students);

    interface ICertificateRepository {
    }
}
