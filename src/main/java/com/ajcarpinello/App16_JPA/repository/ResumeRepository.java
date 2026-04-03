package com.ajcarpinello.App16_JPA.repository;


import com.ajcarpinello.App16_JPA.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
