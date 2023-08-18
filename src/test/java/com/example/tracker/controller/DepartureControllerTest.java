package com.example.tracker.controller;

import com.example.tracker.helper.DepartureHelper;
import com.example.tracker.repository.DepStatusRepository;
import com.example.tracker.repository.DepartureRepository;
import com.example.tracker.service.DepartureServiceImpl;
import com.example.tracker.util.JsonUtil;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartureController.class)
public class DepartureControllerTest {

    @MockBean
    private DepartureServiceImpl departureService;
    @MockBean
    private DepartureRepository departureRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception {
        when(departureService.create(any(), any(), any(), any(), any())).thenReturn(DepartureHelper.getDeparture());

        mockMvc.perform(post("/api/v1/departure/create/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.writeValue(DepartureHelper.getDepartureDto())))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(DepartureHelper.getDeparture())))
                .andExpect(status().isCreated());
    }

    @Test
    void moveTo() throws Exception {
        when(departureService.moveTo(any(), any())).thenReturn(DepartureHelper.getDeparture());
        mockMvc.perform(post("/api/v1/departure/move/1")
                .content("010203"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(DepartureHelper.getDeparture())));

    }

    @Test
    void getStatus() throws Exception {
        when(departureService.getCurrentStatus(any())).thenReturn(DepartureHelper.getDepStatus());
        mockMvc.perform(get("/api/v1/departure/getstatus/2"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    /*@Test
    void getAllUsersCards() throws Exception {
        when(cardService.getAllUsersCards(1L)).thenReturn(Set.of(CardHelper.getCardDto()));

        mockMvc.perform(get("/api/v1/card/users/1/cards"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(Set.of(CardHelper.getCardDto()))))
                .andExpect(status().isOk());
    }*/
}
