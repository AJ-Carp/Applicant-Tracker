package com.ajcarpinello.App16_JPA.repository;


import com.ajcarpinello.App16_JPA.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// more functionality then CrudRepository
public interface ApplicantPagingAndSortingRepository extends PagingAndSortingRepository<Applicant, Long> {
}