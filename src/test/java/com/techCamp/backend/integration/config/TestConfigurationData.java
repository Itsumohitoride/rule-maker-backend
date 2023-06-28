package com.techCamp.backend.integration.config;

import com.techCamp.backend.model.User;
import com.techCamp.backend.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@TestConfiguration
public class TestConfigurationData {
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository users,
                                        PasswordEncoder encoder) {
        User normalCustomer = User.builder()
                .firstName("Zara")
                .lastName("Gomez")
                .email("jhonDoe@email.com")
                .password(encoder.encode("password"))
                .phoneNumber("+573258691487")
                .role("admin")
                .build();





        return args -> {


            users.save(normalCustomer);


        };

    }





}
