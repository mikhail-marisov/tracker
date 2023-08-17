package com.example.tracker.controller;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.DepType;
import com.example.tracker.domain.Departure;
import com.example.tracker.dto.CreateDepartureDto;
import com.example.tracker.service.DepartureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departure/")
public class DepartureController {

    DepartureService departureService;

    public DepartureController(DepartureService departureService) {
        this.departureService = departureService;
    }

    //Регистрация отправления
    @PostMapping("/create")
    public ResponseEntity<Departure> create(@RequestBody CreateDepartureDto createDto) {
        Departure departure = departureService.create(DepType.valueOf(createDto.getType().toUpperCase()),
                createDto.getRecipientIndex(),
                createDto.getRecipientAddress(),
                createDto.getRecipientName(),
                createDto.getPostOfficeIndex());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(departure);
    }

    //Проверка текущего статуса отправления
    @GetMapping("/getstatus/{id}")
    public ResponseEntity<DepStatus> getCurrentStatus(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departureService.getCurrentStatus(id));
    }

    @PostMapping("/move/{id}")
    public  ResponseEntity<Departure> moveTo(@PathVariable Long id, @RequestBody String postOfficeIndex) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departureService.moveTo(id,postOfficeIndex));
    }

    //Получение всех статусов данного отпраавления
    @GetMapping("/getstatushistory/{id}")
    public ResponseEntity<List<DepStatus>> getStatusHistory(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departureService.getStatusHistory(id));
    }
}
