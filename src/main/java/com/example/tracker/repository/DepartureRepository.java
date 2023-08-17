package com.example.tracker.repository;

import com.example.tracker.domain.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long> {

    Optional<Departure> findById(Long departureId);
 }
