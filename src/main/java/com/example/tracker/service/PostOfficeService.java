package com.example.tracker.service;

import com.example.tracker.domain.PostOffice;

public interface PostOfficeService {

    PostOffice create(String officeIndex, String officeName, String officeAddress);

}
