package com.ajcarpinello.App16_JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String status;
    // @OneToOne creates a foreign key by default, creating a circular dependency
    // we prevent by adding mappedBy, which states that this is not the owner of the relationship
    // mappedBy references the owner of the relationship (applicant field in Resume class)
    /* so mappedBy prevents a resume column from existing at all in this entity table (no circular dependency).
       But the resume field here will still contain the resume, so we can access the resumes through java code (applicant.getResume())
     */
    // when we save an applicant with a resume or application nested within, cascade will persist those inner JSON entities as well
    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Resume resume;

    // one applicant can apply to many applications
    // application meaning the actual act of applying, not job posting (that would be many to many)
    // mappedBy tells hibernate where to check for the applications belonging to an applicant (in case not stored in java memory
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();


    @ManyToMany
    /* for many to many relationships we create a separate table to own the relationships
       because we cant have two values in one entry in the foreign key, and we dont want to
       create multiple rows of the same applicant or job to show that they applied to multiple jobs
       or have multiple applicants */
    // adding joinTable makes this entity the owner of the relationship even though it donst actually have the foreign key in it
    @JoinTable (
        // name of table
        name = "applicants_jobs",
        // primary key of this entity (applicant)
        joinColumns = @JoinColumn(name = "applicantId"),
        // primary key of field below (job)
        inverseJoinColumns = @JoinColumn(name = "jobId")
    )
    private List<Job> jobs = new ArrayList<>();
}