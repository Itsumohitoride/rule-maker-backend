package com.techCamp.backend.configuration;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.techCamp.backend.components.JSONArrayDeserializer;

@ComponentScan
@Configuration
public class JacksonConfig {
    @Autowired
    private JSONArrayDeserializer jsonArrayDeserializer;

    @Bean
    public SimpleModule  customDeserializerModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(JSONArray.class, jsonArrayDeserializer);
        return module;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(customDeserializerModule()); 
        return objectMapper;
    }
}
