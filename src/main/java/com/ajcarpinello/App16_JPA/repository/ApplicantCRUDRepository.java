package com.ajcarpinello.App16_JPA.repository;


import com.ajcarpinello.App16_JPA.entity.Applicant;
import org.springframework.data.repository.CrudRepository;

// most basic repo, supports only simple CRUD actions
public interface ApplicantCRUDRepository extends CrudRepository<Applicant, Long> {
}
