package com.example.tracker.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dep_statuses")
public class DepStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_id")
    private Departure departure;

    @Column(name = "time_in")
    private LocalDateTime timeIn;

    @Column(name = "time_out")
    private LocalDateTime timeOut;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_office_id")
    private PostOffice postOffice;

    public DepStatus() {}

    public DepStatus(Departure departure, LocalDateTime timeIn, LocalDateTime timeOut, PostOffice postOffice) {
        this.departure = departure;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.postOffice = postOffice;
    }

    public Long getId() {
        return id;
    }

    public Departure getDeparture() {
        return departure;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public PostOffice getPostOffice() {
        return postOffice;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public void setPostOffice(PostOffice postOffice) {
        this.postOffice = postOffice;
    }
}
