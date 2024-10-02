package com.example.SpringBoot.repository;

import com.example.SpringBoot.modals.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICertificateRepository extends JpaRepository<Certificate,Long> {
}
