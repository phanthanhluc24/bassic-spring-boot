package com.example.SpringBoot.services.impl;

import com.example.SpringBoot.modals.User;
import com.example.SpringBoot.repository.impl.UserRepository;
import com.example.SpringBoot.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user){
        return userRepository.create(user);
    }
}
