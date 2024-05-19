package com.syshco.referral.controller;

import com.syshco.referral.entity.JobApplication;
import com.syshco.referral.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/jobApplications")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllJobApplications() {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications();
        return ResponseEntity.ok(jobApplications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable UUID id) {
        JobApplication jobApplication = jobApplicationService.getJobApplicationById(id);
        return ResponseEntity.ok(jobApplication);
    }

    @PostMapping
    public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication) {
        JobApplication createdJobApplication = jobApplicationService.createJobApplication(jobApplication);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobApplication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(@PathVariable UUID id, @RequestBody JobApplication updatedJobApplication) {
        JobApplication jobApplication = jobApplicationService.updateJobApplication(id, updatedJobApplication);
        return ResponseEntity.ok(jobApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable UUID id) {
        jobApplicationService.deleteJobApplication(id);
        return ResponseEntity.noContent().build();
    }
}
