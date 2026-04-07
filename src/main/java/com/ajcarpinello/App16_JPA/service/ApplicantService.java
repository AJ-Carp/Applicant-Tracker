package com.ajcarpinello.App16_JPA.service;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.entity.Application;
import com.ajcarpinello.App16_JPA.entity.Resume;
import com.ajcarpinello.App16_JPA.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public List<Applicant> getByStatus(String status) {
        return applicantRepository.findByStatusOrderByNameDesc(status);
    }

    public List<Applicant> getByPartialName(String name) {
        return applicantRepository.findByPartialName(name);
    }

    public Applicant saveApplicant(Applicant applicant) {
        Resume resume = applicant.getResume();
        // making sure Resume and Application applicant field is not null
        // because remember the resume and application will cascade and cannot have null applicant fields
        if (resume != null) {
            resume.setApplicant(applicant);
        }
        for (Application app : applicant.getApplications()) {
            app.setApplicant(applicant);
        }
        return applicantRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page, int size) {
        return applicantRepository.findAll(PageRequest.of(page, size));
    }


}
