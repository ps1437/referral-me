package com.syshco.referral.entity;

import com.syshco.referral.entity.enums.ReferralStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "Referrals")

public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "referrer_id")
    private User referrer;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobDetails jobDetails;

    @Enumerated(EnumType.STRING)
    private ReferralStatus status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

}
