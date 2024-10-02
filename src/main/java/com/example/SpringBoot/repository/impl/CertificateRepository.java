package com.example.SpringBoot.repository.impl;

import com.example.SpringBoot.modals.Certificate;
import com.example.SpringBoot.repository.ICertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CertificateRepository {
    @Autowired
    private ICertificateRepository iCertificateRepository;

    public Certificate create(Certificate certificate) {
        Certificate saveCertificate = new Certificate();

        saveCertificate.setName(certificate.getName());
        saveCertificate.setType(certificate.getType());

        return iCertificateRepository.save(saveCertificate);
    }
}
