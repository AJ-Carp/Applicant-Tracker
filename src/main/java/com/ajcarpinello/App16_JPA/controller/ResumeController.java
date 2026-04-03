package com.ajcarpinello.App16_JPA.controller;

import com.ajcarpinello.App16_JPA.entity.Resume;
import com.ajcarpinello.App16_JPA.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/{applicantId}/resume")
    public ResponseEntity<Resume> addResume(@PathVariable Long applicantId, @RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.addResume(applicantId, resume));
    }
}
