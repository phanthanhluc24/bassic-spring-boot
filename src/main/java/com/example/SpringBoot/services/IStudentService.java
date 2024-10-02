package com.example.SpringBoot.services;

import com.example.SpringBoot.modals.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IStudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Student save(Student student);


}
