package com.example.tracker.dto;

public class CreateDepartureDto {

    private String type;
    private String recipientIndex;
    private String recipientAddress;
    private String recipientName;

    private String  postOfficeIndex;

    public CreateDepartureDto(String type, String recipientIndex, String recipientAddress, String recipientName, String postOfficeIndex) {
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
        this.postOfficeIndex = postOfficeIndex;
    }

    public String getPostOfficeIndex() {
        return postOfficeIndex;
    }

    public String getType() {
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

    public void setType(String type) {
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

    public void setPostOfficeIndex(String postOfficeIndex) {
        this.postOfficeIndex = postOfficeIndex;
    }
}
