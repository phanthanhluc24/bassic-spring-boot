package com.example.SpringBoot.modals;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "full_name")
    String fullName;
    @Column(name = "province")
    String province;
    @Column(name = "gender")
    String Gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    List<Enrollment> enrollments = new ArrayList<>();
}
