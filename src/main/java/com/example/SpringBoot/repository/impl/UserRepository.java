package com.example.SpringBoot.repository.impl;

import com.example.SpringBoot.dto.ApiResponse;
import com.example.SpringBoot.modals.User;
import com.example.SpringBoot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private IUserRepository iUserRepository;

    public User create(User user){
        User newStudent = new User();
        newStudent.setFullName(user.getFullName());
        return iUserRepository.save(newStudent);
    }
}
