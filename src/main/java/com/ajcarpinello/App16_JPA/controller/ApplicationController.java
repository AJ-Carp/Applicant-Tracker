package com.ajcarpinello.App16_JPA.controller;

import com.ajcarpinello.App16_JPA.entity.Application;
import com.ajcarpinello.App16_JPA.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("{applicantId}/addApplication")
    public Application addApplication(@PathVariable Long applicantId, @RequestBody Application application) {
        return applicationService.addApplication(applicantId, application);
    }
}
