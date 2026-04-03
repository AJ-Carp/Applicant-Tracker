package com.ajcarpinello.App16_JPA.service;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.repository.ApplicantJPARepository;
import com.ajcarpinello.App16_JPA.repository.ApplicantPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantJPARepository applicantJPARepository;

    public List<Applicant> getAllApplicants() {
        return applicantJPARepository.findAll();
    }

    public List<Applicant> getByStatus(String status) {
        return applicantJPARepository.findByStatusOrderByNameDesc(status);
    }

    public List<Applicant> getByPartialName(String name) {
        return applicantJPARepository.findByPartialName(name);
    }

    public Applicant saveApplicant(Applicant applicant) {
        return applicantJPARepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page, int size) {
        return applicantJPARepository.findAll(PageRequest.of(page, size));
    }


}
