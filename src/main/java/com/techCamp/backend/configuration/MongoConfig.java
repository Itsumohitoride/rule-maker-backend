package com.techCamp.backend.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.Converter;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.techCamp.backend.components.JSONArrayReadConverter;
import com.techCamp.backend.components.JSONArraySerializer;
import com.techCamp.backend.components.JSONObjectReadConverter;

@Configuration
@EnableMongoRepositories(basePackages = {"org.spring.mongo.demo","com.techCamp.backend.repository"})
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return "rule_maker";
    }

    @Override
    public MongoClient mongoClient() {
        MongoClient client = MongoClients.create("mongodb+srv://editor:editor@basededatosprueba.mtzwhuy.mongodb.net/?retryWrites=true&w=majority");
        return client;
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("org.spring.mongo.demo");
    }

    @Override
    public MongoCustomConversions  customConversions() {
        List<Object> converters = new ArrayList<>();
        converters.add(new JSONArrayReadConverter());
        converters.add(new JSONObjectReadConverter());
        return new MongoCustomConversions(converters);
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        var objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(JSONArray.class, new JSONArraySerializer());
        objectMapper.registerModule(module);

        return objectMapper;
    }
}