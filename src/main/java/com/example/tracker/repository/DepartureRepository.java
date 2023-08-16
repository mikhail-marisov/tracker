package com.example.tracker.repository;

import com.example.tracker.domain.Departure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartureRepository extends JpaRepository<Departure, Long> {
}
