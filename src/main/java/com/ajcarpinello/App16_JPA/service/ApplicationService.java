package com.ajcarpinello.App16_JPA.service;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.entity.Application;
import com.ajcarpinello.App16_JPA.repository.ApplicantRepository;
import com.ajcarpinello.App16_JPA.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    public Application addApplication(Long applicantId, Application application) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            application.setApplicant(applicant);
        }
        return applicationRepository.save(application);
    }
}
