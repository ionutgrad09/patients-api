package com.app.patients_api.model.entities;

import com.app.patients_api.model.Role;
import jakarta.persistence.*;
import lombok.*;


@Data
@Table(name = "app_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private Long unitId;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}