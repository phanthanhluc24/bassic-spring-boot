package com.example.SpringBoot.modals;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "another_certificate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnotherCertificateUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    User user;

    @Column(name = "certificate",nullable = true)
    String certificate;

    @Column(name = "programming",nullable = true)
    String programming;

    @Column(name = "area_working",nullable = true)
    String area_working;
}
