package com.example.tracker.service;

import com.example.tracker.domain.PostOffice;
import com.example.tracker.repository.PostOfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class PostOfficeServiceImpl implements PostOfficeService{

    private PostOfficeRepository postOfficeRepository;

    public PostOfficeServiceImpl(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    @Override
    public PostOffice create(String officeIndex, String officeName, String officeAddress) {

        PostOffice postOffice = new PostOffice(officeIndex, officeName, officeAddress);
        postOfficeRepository.save(postOffice);
        return postOffice;
    }
}
