package com.example.tracker.helper;

import com.example.tracker.domain.Departure;
import com.example.tracker.domain.PostOffice;

public class DepStatusTimeDto {

    private Departure departure;
    private String timeIn;
    private String timeOut;

    private PostOffice postOffice;

    public DepStatusTimeDto(Departure departure, String timeIn, String timeOut, PostOffice postOffice) {
        this.departure = departure;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.postOffice = postOffice;
    }
}
