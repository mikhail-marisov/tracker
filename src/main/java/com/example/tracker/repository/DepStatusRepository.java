package com.example.tracker.repository;

import com.example.tracker.domain.DepStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepStatusRepository extends JpaRepository<DepStatus, Long> {
}
