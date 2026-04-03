package com.ajcarpinello.App16_JPA.service;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.entity.Resume;
import com.ajcarpinello.App16_JPA.repository.ApplicantJPARepository;
import com.ajcarpinello.App16_JPA.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ApplicantJPARepository applicantJPARepository;

    @Autowired
    private ResumeRepository resumeRepository;

    public Resume addResume(Long applicantId, Resume resume) {
        Optional<Applicant> applicantOptional = applicantJPARepository.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);
            return resumeRepository.save(resume);
        } else {
            throw new RuntimeException("Applicant not found with id " + applicantId);
        }
    }
}
