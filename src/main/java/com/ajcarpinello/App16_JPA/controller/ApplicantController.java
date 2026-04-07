package com.ajcarpinello.App16_JPA.controller;

import com.ajcarpinello.App16_JPA.entity.Applicant;
import com.ajcarpinello.App16_JPA.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("getAllApplicants")
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("getByStatus")
    public List<Applicant> getByStatus(@RequestParam String status) {
        return applicantService.getByStatus(status);
    }

    @GetMapping("GetByPartialName")
    public List<Applicant> getByPartialName(@RequestParam String name) {
        return applicantService.getByPartialName(name);
    }

    @PostMapping("saveApplicant")
    public Applicant saveApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicant(applicant);
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicationWithPagination(
        // page and size are a way to break the output into pieces 
        // size is how many records 
        // page is which grouping to show (starting index = 0)
        // example: if you had page 3 and size 4, it would skip 3 groupings of
            @RequestParam int page,
            @RequestParam int size) {
        return applicantService.getApplicantsWithPagination(page, size);
    }
}