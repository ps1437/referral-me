package com.syshco.referral.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "Jobs")
public class JobDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private User postedBy;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters and setters
}
