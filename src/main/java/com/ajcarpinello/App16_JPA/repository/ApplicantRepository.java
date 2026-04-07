package com.ajcarpinello.App16_JPA.repository;


import com.ajcarpinello.App16_JPA.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// extends PagingAndSortingRepository, adding all features
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    // can get pretty specific without having to write any queries
    List<Applicant> findByStatusOrderByNameDesc(String status);

    // if its custom though and JPD cant do it, we can write the query
    @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
    List<Applicant> findByPartialName(@Param("name") String name);
}
