package com.example.SpringBoot.repository.impl;

import com.example.SpringBoot.modals.Certificate;
import com.example.SpringBoot.modals.User;
import com.example.SpringBoot.modals.UserCertificate;
import com.example.SpringBoot.repository.ICertificateRepository;
import com.example.SpringBoot.repository.IUserCertificateRepository;
import com.example.SpringBoot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserCertificateRepository {

    @Autowired
    private IUserCertificateRepository iUserCertificateRepository;
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private ICertificateRepository iCertificateRepository;

    public List<UserCertificate> saveAndUpdate(Long userId, List<Long> certificateIds) {

        User user = iUserRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }
        List<UserCertificate> newUserCertificates = new ArrayList<>();

        List<UserCertificate> currentUserCertificates = iUserCertificateRepository.findByUserId(userId);

        for (Long certificateId : certificateIds) {
            Certificate certificate = iCertificateRepository.findById(certificateId).orElse(null);
            if (certificate != null) {
                Optional<UserCertificate> foundCertificate = currentUserCertificates.stream()
                        .filter(uc -> uc.getCertificate().getId().equals(certificateId))
                        .findFirst();

                if (foundCertificate.isPresent()) {
                    UserCertificate userCertificate = foundCertificate.get();
                    if (userCertificate.getStatus() == 2) {
                        userCertificate.setStatus(1);
                        iUserCertificateRepository.save(userCertificate);
                    }
                } else {
                    UserCertificate userCertificate = new UserCertificate();
                    userCertificate.setUser(user);
                    userCertificate.setCertificate(certificate);
                    userCertificate.setStatus(1);
                    newUserCertificates.add(iUserCertificateRepository.save(userCertificate));
                }
            }
        }

        currentUserCertificates.forEach(userCertificate -> {
            if (!certificateIds.contains(userCertificate.getCertificate().getId())) {
                userCertificate.setStatus(2);
                iUserCertificateRepository.save(userCertificate);
            }
        });
        return newUserCertificates;

    }
}
