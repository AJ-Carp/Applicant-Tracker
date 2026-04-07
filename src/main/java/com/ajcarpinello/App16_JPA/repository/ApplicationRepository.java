package com.ajcarpinello.App16_JPA.repository;

import com.ajcarpinello.App16_JPA.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
