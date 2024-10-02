package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.ApiResponse;
import com.example.SpringBoot.modals.Certificate;
import com.example.SpringBoot.services.impl.CertificateService;
import com.example.SpringBoot.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @PostMapping
    public ResponseEntity<ApiResponse<Certificate>> create (@RequestBody Certificate certificate){
        return JsonResponse.ok(certificateService.create(certificate));
    }
}
