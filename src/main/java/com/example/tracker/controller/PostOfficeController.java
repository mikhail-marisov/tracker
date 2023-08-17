package com.example.tracker.controller;

import com.example.tracker.domain.PostOffice;
import com.example.tracker.dto.CreatePostOfficeDto;
import com.example.tracker.service.PostOfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/postoffice/")
public class PostOfficeController {

    private PostOfficeService postOfficeService;

    public PostOfficeController(PostOfficeService postOfficeService) {
        this.postOfficeService = postOfficeService;
    }

    @PostMapping("/create")
    public ResponseEntity<PostOffice> create(@RequestBody CreatePostOfficeDto createPostOfficeDto) {

        PostOffice postOffice =  postOfficeService.create(
                createPostOfficeDto.getOfficeIndex(),
                createPostOfficeDto.getOfficeName(),
                createPostOfficeDto.getOfficeAddress()
        );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postOffice);
    }
}
