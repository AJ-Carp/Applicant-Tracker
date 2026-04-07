package com.ajcarpinello.App16_JPA.service;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.entity.Resume;
import com.ajcarpinello.App16_JPA.repository.ApplicantRepository;
import com.ajcarpinello.App16_JPA.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    public Resume addResume(Long applicantId, Resume resume) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);

            // using this line actually puts the resume in the applicant's resume field in Java memory.
            /* it's not required because hibernate sees the applicants resume field is mapped by "applicant" in the resumes table,
               so we if we just leave it null (dont set the applicant to have a resume like we are below), then when we fetch this
               applicant, hibernate will go to the resumes table and look for foreign key that maps to the applicants and check if
               the applicant has a resume. If it does, it adds that resume to the applicant in memory (applicant.setResume(resume)).
             */
            // its still good to have this line though to make the code more clear and also to reduce work for hibernate and prevent some weird bugs
            applicant.setResume(resume);
            return resumeRepository.save(resume);
        } else {
            throw new RuntimeException("Applicant not found with id " + applicantId);
        }
    }
}
