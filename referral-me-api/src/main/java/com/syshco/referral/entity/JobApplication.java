package com.syshco.referral.entity;

import com.syshco.referral.entity.enums.ReferralStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "Applications")
@Data
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobDetails jobDetails;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant;

    @Enumerated(EnumType.STRING)
    private ReferralStatus status;

    @Column(name = "applied_at")
    private Timestamp appliedAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


}
