package com.example.tracker.service;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.DepType;
import com.example.tracker.domain.Departure;
import com.example.tracker.domain.PostOffice;
import com.example.tracker.repository.DepStatusRepository;
import com.example.tracker.repository.DepartureRepository;
import com.example.tracker.repository.PostOfficeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartureServiceImpl implements DepartureService{

    private DepartureRepository departureRepository;
    private PostOfficeRepository postOfficeRepository;
    private DepStatusRepository depStatusRepository;
    private DepstatusService depstatusService;

    public DepartureServiceImpl(DepartureRepository departureRepository,
                                PostOfficeRepository postOfficeRepository,
                                DepStatusRepository depStatusRepository,
                                DepstatusService depstatusService) {
        this.departureRepository = departureRepository;
        this.postOfficeRepository = postOfficeRepository;
        this.depStatusRepository = depStatusRepository;
        this.depstatusService = depstatusService;
    }

    @Override
    public Departure create(DepType type, String recipientIndex, String recipientAddress, String recipientName, String postOfficeIndex) {

        Departure departure = new Departure(type, recipientIndex, recipientAddress, recipientName);
        List<DepStatus> statusList = new ArrayList<>();

        DepStatus status = depstatusService.create(departure, postOfficeIndex);

        statusList.add(status);
        departure.setDepStatusList(statusList);

        departureRepository.save(departure);
        return departure;
    }

    @Override
    public Departure moveTo(Long departureId, String postOfficeIndex) {

        Departure departure = departureRepository.findById(departureId)
                .orElseThrow(() -> new EntityNotFoundException("Отправления с Id " + departureId + " не существует"));

        getCurrentStatus(departureId).setTimeOut(LocalDateTime.now());
        DepStatus status = depstatusService.create(departure, postOfficeIndex);
        if (departure.getRecipientIndex().equalsIgnoreCase(postOfficeIndex)) {
            status.setDelivered(true);
        }
        departure.getDepStatusList().add(status);


        departureRepository.save(departure);
        return departure;
    }

    @Override
    public DepStatus getCurrentStatus(Long departureId) {
        Departure departure = departureRepository.findById(departureId)
                .orElseThrow(() -> new EntityNotFoundException("Отправления с Id " + departureId + " не существует"));

        return departure.getDepStatusList().get(departure.getDepStatusList().size() - 1);
    }

    @Override
    public List<DepStatus> getStatusHistory(Long departureId) {
        Departure departure = departureRepository.findById(departureId)
                .orElseThrow(() -> new EntityNotFoundException("Отправления с Id " + departureId + " не существует"));
        return departure.getDepStatusList();
    }


}
