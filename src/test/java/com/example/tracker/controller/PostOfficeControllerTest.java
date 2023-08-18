package com.example.tracker.controller;

import com.example.tracker.helper.DepartureHelper;
import com.example.tracker.helper.PostOfficeHelper;
import com.example.tracker.service.PostOfficeService;
import com.example.tracker.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostOfficeController.class)
public class PostOfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostOfficeService postOfficeService;

    @Test
    void create() throws Exception {

        when(postOfficeService.create(any(), any(), any())).thenReturn(PostOfficeHelper.getPostOffice());

        mockMvc.perform(post("/api/v1/postoffice/create/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(PostOfficeHelper.getPostOffice())))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(PostOfficeHelper.getPostOffice())))
                .andExpect(status().isCreated());
    }
}
