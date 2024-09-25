package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.ApiResponse;
import com.example.SpringBoot.exception.ApiException;
import com.example.SpringBoot.exception.ErrorCode;
import com.example.SpringBoot.modals.Employee;
import com.example.SpringBoot.util.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(),"Phan Thanh Luc","Development"),
                    new Employee(UUID.randomUUID(),"Bui Xuan Hoan","Waitress"),
                    new Employee(UUID.randomUUID(),"Nguyen Huu Thang","Waitress")
            )
    );

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> listEmployee(){
        return JsonResponse.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> findById(@PathVariable("id") UUID id){
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(JsonResponse::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));
    }
}
