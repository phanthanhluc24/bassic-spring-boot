package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.ApiResponse;
import com.example.SpringBoot.modals.UserCertificate;
import com.example.SpringBoot.request.UserCertificateRequest;
import com.example.SpringBoot.services.impl.UserCertificateService;
import com.example.SpringBoot.util.JsonResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-certificate")
@AllArgsConstructor
public class UserCertificateController {
    @Autowired
    private UserCertificateService userCertificateService;

    @PostMapping
    public ResponseEntity<ApiResponse<List<UserCertificate>>> saveAndUpdate (@RequestBody UserCertificateRequest request){
        return JsonResponse.ok(userCertificateService.saveAndUpdate(request.getUserId(), request.getCertificateIds()));
    }
}
