package com.example.tracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departures")
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dep_type")
    private DepType type;

    @Column(name = "recipient_index")
    private String recipientIndex;

    @Column(name = "recipient_adderss")
    private String recipientAddress;

    @Column(name = "recipient_name")
    private String recipientName;

    @OrderBy("timeIn")
    @OneToMany(mappedBy = "departure")
    private List<DepStatus> depStatusList;

    public Departure() {}
    public Departure(DepType type, String recipientIndex, String recipientAddress, String recipientName) {
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
    }

    public Long getId() {
        return id;
    }

    public DepType getType() {
        return type;
    }

    public String getRecipientIndex() {
        return recipientIndex;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public List<DepStatus> getDepStatusList() {
        return depStatusList;
    }

    public void setType(DepType type) {
        this.type = type;
    }

    public void setRecipientIndex(String recipientIndex) {
        this.recipientIndex = recipientIndex;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setDepStatusList(List<DepStatus> depStatusList) {
        this.depStatusList = depStatusList;
    }
}
