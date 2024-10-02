package com.example.SpringBoot.services.impl;

import com.example.SpringBoot.modals.UserCertificate;
import com.example.SpringBoot.repository.IUserCertificateRepository;
import com.example.SpringBoot.repository.impl.UserCertificateRepository;
import com.example.SpringBoot.services.IUserCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCertificateService implements IUserCertificateService {

    @Autowired
    private UserCertificateRepository userCertificateRepository;

    public List<UserCertificate> saveAndUpdate (Long userId,List<Long> certificateId){
        return userCertificateRepository.saveAndUpdate(userId,certificateId);
    }
}
