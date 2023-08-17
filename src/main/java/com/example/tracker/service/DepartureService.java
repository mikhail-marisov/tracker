package com.example.tracker.service;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.DepType;
import com.example.tracker.domain.Departure;
import com.example.tracker.domain.PostOffice;

import java.time.LocalDateTime;
import java.util.List;

public interface DepartureService {

    Departure create(DepType type, String recipientIndex, String recipientAddress, String recipientName, String postOfficeIndex);

    //Передвижение отправления с одного пункта в другой
    Departure moveTo(Long departureId, String postOfficeIndex);

    DepStatus getCurrentStatus(Long departureId);

    List<DepStatus> getStatusHistory(Long departureId);

}
