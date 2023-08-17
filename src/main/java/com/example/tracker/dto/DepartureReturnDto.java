package com.example.tracker.dto;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.DepType;

import javax.persistence.*;
import java.util.List;

public class DepartureReturnDto {

    private Long id;
    private DepType type;
    private String recipientIndex;
    private String recipientAddress;
    private String recipientName;
    //private List<DepStatus> depStatusList;


    public DepartureReturnDto(Long id, DepType type, String recipientIndex, String recipientAddress, String recipientName) {
        this.id = id;
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
}
