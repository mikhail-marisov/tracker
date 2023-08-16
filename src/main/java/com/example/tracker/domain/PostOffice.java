package com.example.tracker.domain;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "postOffice")
    DepStatus depStatus;

    public PostOffice() {}

    public PostOffice(String officeIndex, String officeName, String officeAddress, DepStatus depStatus) {
        this.officeIndex = officeIndex;
        this.officeName = officeName;
        this.officeAddress = officeAddress;
        this.depStatus = depStatus;
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

    public DepStatus getDepStatus() {
        return depStatus;
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

    public void setDepStatus(DepStatus depStatus) {
        this.depStatus = depStatus;
    }
}
