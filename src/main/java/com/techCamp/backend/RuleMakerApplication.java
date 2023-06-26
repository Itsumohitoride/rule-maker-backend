   package com.techCamp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@EnableAutoConfiguration 
@SpringBootApplication
@ComponentScan(basePackages = {"com.techCamp.backend.components","com.techCamp.backend","com.techCamp.backend.configuration","com.techCamp.backend.repository"})
public class RuleMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuleMakerApplication.class, args);
	}
  
}
 