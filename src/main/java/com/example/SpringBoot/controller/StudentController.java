package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.ApiResponse;
import com.example.SpringBoot.exception.ApiException;
import com.example.SpringBoot.exception.ErrorCode;
import com.example.SpringBoot.modals.Student;
import com.example.SpringBoot.services.IStudentService;
import com.example.SpringBoot.services.impl.StudentService;
import com.example.SpringBoot.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class StudentController {
//    @Autowired
    IStudentService studentService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents(){
        return JsonResponse.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> findStudentById(@PathVariable("id") Long id){
        return studentService.findById(id)
                .map(JsonResponse::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.STUDENT_NOT_EXIT));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Student>> create (@RequestBody Student student){
             studentService.save(student);
             return JsonResponse.create(student);

    }
}
