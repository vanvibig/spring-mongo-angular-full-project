package com.kv.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConfigurationProperties
@EnableMongoRepositories("com.kv.repositorie")
@Import(value = MongoAutoConfiguration.class)
public class DatabaseConfiguration {
}
