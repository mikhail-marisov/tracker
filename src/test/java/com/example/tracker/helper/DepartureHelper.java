package com.example.tracker.helper;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.DepType;
import com.example.tracker.domain.Departure;
import com.example.tracker.domain.PostOffice;
import com.example.tracker.dto.CreateDepartureDto;

import java.time.LocalDateTime;

public class DepartureHelper {

    public static Departure getDeparture() {
        return new Departure(DepType.LETTER, "010203", "Address", "Name" );

    }

    public static DepStatus getDepStatus() {

        return new DepStatus(new Departure(DepType.LETTER, "010203", "Address", "Name" ),
                LocalDateTime.of(2023, 9, 19, 14, 5),
                LocalDateTime.of(2023, 9, 19, 14, 5),
                new PostOffice("010203", "Name", "Address"));
    }

    public static CreateDepartureDto getDepartureDto() {
        return new CreateDepartureDto("LETTER", "010203", "Address", "Name", "010203");
    }
}
