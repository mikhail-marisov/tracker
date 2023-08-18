package com.example.tracker.service;

import com.example.tracker.repository.PostOfficeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostOfficeServiceTest {

    @Mock
    private PostOfficeRepository postOfficeRepository;
    @InjectMocks
    private PostOfficeServiceImpl postOfficeService;

    @Test
    void create() {
        postOfficeService.create("010203", "Name", "Address");
        verify(postOfficeRepository).save(any());
    }
}
