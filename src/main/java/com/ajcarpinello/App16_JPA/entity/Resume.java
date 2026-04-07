package com.ajcarpinello.App16_JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @OneToOne
    // @JoinColumn says that this entity is the owner of the relationship, meaning it contains the foreign key
    // the name of column will be applicantId and cannot be false, it by default takes the primary key of the applicants
    @JoinColumn(name = "applicantId", nullable = false)
    // ignore the inner applicant JSON in input and output
    @JsonIgnore
    private Applicant applicant;

    /* Jackson will automatically call
       this method and add "applicantId" to the JSON output
       so that we see the foreign key (totally optional)
     */
    public Long getApplicantId() {
        return applicant != null ? applicant.getId() : null;
    }
}
