package com.example.tracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_index")
    private String officeIndex;
    @Column(name = "office_name")
    private String officeName;
    @Column(name = "Office_address")
    private String officeAddress;


    public PostOffice() {}

    public PostOffice(String officeIndex, String officeName, String officeAddress) {
        this.officeIndex = officeIndex;
        this.officeName = officeName;
        this.officeAddress = officeAddress;
    }

    public Long getId() {
        return id;
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



    public void setOfficeIndex(String officeIndex) {
        this.officeIndex = officeIndex;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }


}
