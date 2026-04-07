package com.ajcarpinello.App16_JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    private String position;

    /* so in these relationship annotations, the first part (Many) represents
    the current entity that the annotation is in (applications), and the second
    part (One) represents the field that the annotations is above (applicant). */
    // Many applications per applicant
    @ManyToOne
    @JoinColumn(name = "applicantId", nullable = false)
    @JsonIgnore
    private Applicant applicant;
}
