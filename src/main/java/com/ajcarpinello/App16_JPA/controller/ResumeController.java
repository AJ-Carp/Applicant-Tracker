package com.ajcarpinello.App16_JPA.controller;

import com.ajcarpinello.App16_JPA.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/applicantId/resume")
    public ResponseEntity
}
