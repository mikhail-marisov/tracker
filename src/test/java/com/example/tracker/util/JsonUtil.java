package com.example.tracker.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public JsonUtil() {
    }

    public static <T> String writeValue(T obj){
        mapper.registerModule(new JavaTimeModule());
        try{
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e){
            throw new IllegalArgumentException("Invalid write to JSON:\n'" + obj + "'", e);
        }
    }

    public static <T> T readValue(String json, Class<T> clazz){
        try{
            return mapper.readValue(json, clazz);
        } catch (IOException e){
            throw new IllegalArgumentException("Invalid read from JSON:\n'" + json + "'", e);
        }
    }
}
