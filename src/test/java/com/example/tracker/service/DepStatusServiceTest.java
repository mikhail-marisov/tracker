package com.example.tracker.service;

import com.example.tracker.domain.Departure;
import com.example.tracker.helper.DepartureHelper;
import com.example.tracker.helper.PostOfficeHelper;
import com.example.tracker.repository.DepStatusRepository;
import com.example.tracker.repository.PostOfficeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepStatusServiceTest {

    @Mock
    private DepStatusRepository depStatusRepository;
    @Mock
    private PostOfficeRepository postOfficeRepository;

    @InjectMocks
    private DepstatusServiceImpl depstatusService;

    @Test
    void create() {
        Departure departure = DepartureHelper.getDepartureWithStatus();
        when(postOfficeRepository.findByOfficeIndex(any())).thenReturn(Optional.of(PostOfficeHelper.getPostOffice()));
        depstatusService.create(departure, "010203");
        verify(depStatusRepository).save(any());
    }
}
