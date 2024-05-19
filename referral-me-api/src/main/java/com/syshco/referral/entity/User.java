package com.syshco.referral.entity;


import com.syshco.referral.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "google_id")
    private String googleId;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // Getters and setters
}
