package com.example.tracker.service;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.Departure;

public interface DepstatusService {

    DepStatus create(Departure departure, String postOfficeIndex);
}
