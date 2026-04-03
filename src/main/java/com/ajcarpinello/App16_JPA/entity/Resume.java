package com.ajcarpinello.App16_JPA.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    // one resume per applicant
    @OneToOne
    // JoinColumn specifies the foreign key
    /* the column won't actually contain applicants,
       it will contain their id's and the name of this column will be applicantId */
    @JoinColumn(name = "applicantId", nullable = false)
    private Applicant applicant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
