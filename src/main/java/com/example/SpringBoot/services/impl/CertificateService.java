package com.example.SpringBoot.services.impl;

import com.example.SpringBoot.modals.Certificate;
import com.example.SpringBoot.repository.ICertificateRepository;
import com.example.SpringBoot.repository.impl.CertificateRepository;
import com.example.SpringBoot.services.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService implements ICertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public Certificate create (Certificate certificate) {
        return certificateRepository.create(certificate);
    }
}
