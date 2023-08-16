package com.example.tracker.repository;

import com.example.tracker.domain.DepStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepStatusRepository extends JpaRepository<DepStatus, Long> {
}
