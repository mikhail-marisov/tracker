package com.example.tracker.service;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.Departure;
import com.example.tracker.domain.PostOffice;

import java.time.LocalDateTime;

public interface DepstatusService {

    DepStatus create(Departure departure, LocalDateTime timeIn, LocalDateTime timeOut, PostOffice postOffice);
}
