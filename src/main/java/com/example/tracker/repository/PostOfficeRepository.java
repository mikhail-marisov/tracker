package com.example.tracker.repository;

import com.example.tracker.domain.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {

    Optional<PostOffice> findByOfficeIndex(String officeIndex);
}
