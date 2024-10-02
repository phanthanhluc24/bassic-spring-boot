package com.example.SpringBoot.services;

import com.example.SpringBoot.modals.UserCertificate;

import java.util.List;

public interface IUserCertificateService {
    List<UserCertificate> saveAndUpdate(Long userId, List<Long> certificateId);
}
