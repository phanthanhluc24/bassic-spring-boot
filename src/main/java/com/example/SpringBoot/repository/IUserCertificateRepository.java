package com.example.SpringBoot.repository;

import com.example.SpringBoot.modals.UserCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserCertificateRepository extends JpaRepository<UserCertificate,Long> {
    List<UserCertificate> findByUserId(Long userId);

    Optional<UserCertificate> findByStatus(Integer status);
}
