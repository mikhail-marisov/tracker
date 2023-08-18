package com.example.tracker.service;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.Departure;
import com.example.tracker.repository.DepStatusRepository;
import com.example.tracker.repository.PostOfficeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class DepstatusServiceImpl implements DepstatusService{

    private PostOfficeRepository postOfficeRepository;
    private DepStatusRepository depStatusRepository;

    public DepstatusServiceImpl(PostOfficeRepository postOfficeRepository, DepStatusRepository depStatusRepository) {
        this.postOfficeRepository = postOfficeRepository;
        this.depStatusRepository = depStatusRepository;
    }

    @Override
    public DepStatus create(Departure departure, String postOfficeIndex) {

        DepStatus status = new DepStatus(
                departure,
                LocalDateTime.now(),
                null,
                postOfficeRepository.findByOfficeIndex(postOfficeIndex)
                        .orElseThrow(() -> new EntityNotFoundException("Почтовое отделение с индексом " + postOfficeIndex + " не существует")));
        depStatusRepository.save(status);
        return status;
    }
}
