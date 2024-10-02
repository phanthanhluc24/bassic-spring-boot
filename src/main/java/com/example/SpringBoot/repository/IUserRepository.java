package com.example.SpringBoot.repository;

import com.example.SpringBoot.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
