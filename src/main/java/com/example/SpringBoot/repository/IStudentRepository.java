package com.example.SpringBoot.repository;

import com.example.SpringBoot.modals.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IStudentRepository {
    List<Student> findAll();
    Optional<Student> findById(UUID id);
    Student save(Student students);
}
