package com.example.tracker.dto;

public class CreatePostOfficeDto {
    private String officeIndex;
    private String officeName;
    private String officeAddress;

    public CreatePostOfficeDto(String officeIndex, String officeName, String officeAddress) {
        this.officeIndex = officeIndex;
        this.officeName = officeName;
        this.officeAddress = officeAddress;
    }

    public String getOfficeIndex() {
        return officeIndex;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }
}
