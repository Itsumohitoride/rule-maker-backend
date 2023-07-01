package com.techCamp.backend.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.techCamp.backend.components.JSONArrayReadConverter;
import com.techCamp.backend.components.JSONObjectReadConverter;

@Configuration
@EnableMongoRepositories(basePackages = {"org.spring.mongo.demo","com.techCamp.backend.repository"})
public class MongoConfig extends AbstractMongoClientConfiguration {

    private MongoDatabaseFactory mongoFactory;

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
        MongoCustomConversions conversions=new MongoCustomConversions(converters);
        return conversions;
    }

    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory,
			MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(databaseFactory);
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
		converter.setCustomConversions(customConversions);
		converter.setCodecRegistryProvider(databaseFactory);
        converter.setMapKeyDotReplacement(".");
        
        return converter;
    }

    
}