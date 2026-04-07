package com.ajcarpinello.App16_JPA.service;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.entity.Job;
import com.ajcarpinello.App16_JPA.repository.ApplicantRepository;
import com.ajcarpinello.App16_JPA.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public Applicant addJobToApplicant(Long applicantId, Long jobId) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
        Optional<Job> jobOptional = jobRepository.findById(jobId);

        if (applicantOptional.isPresent() && jobOptional.isPresent()) {

            Applicant applicant = applicantOptional.get();
            Job job = jobOptional.get();

            applicant.getJobs().add(job);
            job.getApplicants().add(applicant);
            return applicantRepository.save(applicant);
        } else {
            throw new IllegalArgumentException("Applicant or job not found");
        }
    }
}
