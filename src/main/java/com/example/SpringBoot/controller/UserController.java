package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.ApiResponse;
import com.example.SpringBoot.modals.User;
import com.example.SpringBoot.services.impl.UserService;
import com.example.SpringBoot.util.JsonResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<User>> create(@RequestBody User user) {
           return JsonResponse.ok(userService.create(user));
    }
}
