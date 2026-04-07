package com.ajcarpinello.App16_JPA.repository;

import com.ajcarpinello.App16_JPA.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
