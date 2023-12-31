package com.example.tracker.service;

import com.example.tracker.domain.DepType;
import com.example.tracker.domain.Departure;
import com.example.tracker.helper.DepartureHelper;
import com.example.tracker.repository.DepStatusRepository;
import com.example.tracker.repository.DepartureRepository;
import com.example.tracker.repository.PostOfficeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartureServiceTest {

    @Mock
    private DepartureRepository departureRepository;
    @Mock
    private DepStatusRepository depStatusRepository;
    @Mock
    private PostOfficeRepository postOfficeRepository;
    @Mock
    private DepstatusServiceImpl depstatusService;
    @InjectMocks
    private DepartureServiceImpl departureService;

    @Test
    void create() {

        when(depstatusService.create(any(), any())).thenReturn(DepartureHelper.getDepStatus());
        departureService.create(DepType.LETTER, "010203", "Address", "Name", "020203");
        verify(departureRepository).save(any());
    }

    @Test
    void moveTo() {
        when(depstatusService.create(any(), any())).thenReturn(DepartureHelper.getDepStatus());
        when(departureRepository.findById(any())).thenReturn(Optional.of(DepartureHelper.getDepartureWithStatus()));
        departureService.moveTo(1L, "010203");
        verify(departureRepository).save(any());
    }

    @Test
    void getCurrentStatus() {

        when(departureRepository.findById(any())).thenReturn(Optional.of(DepartureHelper.getDepartureWithStatus()));
        departureService.getCurrentStatus(1L);
    }

    @Test
    void getStatusIllegalDeparture() {

        when(departureRepository.findById(any())).thenReturn(Optional.empty());
        EntityNotFoundException ex = assertThrows(EntityNotFoundException.class, () -> departureService.getCurrentStatus(1L));
    }

    @Test
    void getStatusHistory() {
        Departure departure = DepartureHelper.getDepartureWithStatus();
        when(departureRepository.findById(any())).thenReturn(Optional.of(departure));

        assertThat(departureService.getStatusHistory(1L)).isEqualTo(departure.getDepStatusList());
    }
}
