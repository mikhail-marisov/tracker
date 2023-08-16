package com.example.tracker.repository;

import com.example.tracker.domain.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
}
