package com.ajcarpinello.App16_JPA.controller;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.entity.Job;
import com.ajcarpinello.App16_JPA.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("saveJob")
    public ResponseEntity<Job> saveJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.saveJob(job));
    }

    @PostMapping("addJobToApplicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId, @RequestParam Long jobId) {
        Applicant updatedApplicant = jobService.addJobToApplicant(applicantId, jobId);
        return ResponseEntity.ok(updatedApplicant);
    }

}
