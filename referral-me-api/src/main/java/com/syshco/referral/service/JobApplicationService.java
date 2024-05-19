package com.syshco.referral.service;

import com.syshco.referral.exception.NotFoundException;
import com.syshco.referral.entity.JobApplication;
import com.syshco.referral.repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public JobApplication getJobApplicationById(UUID id) {
        return jobApplicationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Application not found with id: " + id));
    }

    @Transactional
    public JobApplication createJobApplication(JobApplication jobApplication) {
        jobApplication.setAppliedAt(new Timestamp(System.currentTimeMillis()));
        jobApplication.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return jobApplicationRepository.save(jobApplication);
    }

    @Transactional
    public JobApplication updateJobApplication(UUID id, JobApplication updatedJobApplication) {
        JobApplication existingJobApplication = getJobApplicationById(id);

        existingJobApplication.setJobDetails(updatedJobApplication.getJobDetails());
        existingJobApplication.setApplicant(updatedJobApplication.getApplicant());
        existingJobApplication.setStatus(updatedJobApplication.getStatus());
        existingJobApplication.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return jobApplicationRepository.save(existingJobApplication);
    }

    public void deleteJobApplication(UUID id) {
        jobApplicationRepository.deleteById(id);
    }
}
