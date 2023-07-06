package com.techCamp.backend.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techCamp.backend.dto.CreateUsersDTO;
import com.techCamp.backend.dto.LoginDTO;
import com.techCamp.backend.dto.TokenDTO;
import com.techCamp.backend.integration.config.TestConfigurationData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestConfigurationData.class)
@ActiveProfiles(profiles = "test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    public TokenDTO generateAdminToken() throws Exception{
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/token").content(
                                objectMapper.writeValueAsString(new LoginDTO("jhonDoe@email.com", "password"))
                        )
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        return objectMapper.readValue(result.getResponse().getContentAsString(), TokenDTO.class);
    }

    @Test
    @Order(1)
    public void whenTokenIsRequired_ThenTokenHasGiven() throws Exception{
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/token").content(
                                objectMapper.writeValueAsString(new LoginDTO("jhonDoe@email.com", "password")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        TokenDTO tokenDTO = objectMapper.readValue(result.getResponse().getContentAsString(), TokenDTO.class);
        assertNotNull(tokenDTO);
    }

    @Test
    @Order(2)
    public void testCreateUser() throws Exception{
        var newResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/create").content(
                                objectMapper.writeValueAsString(createCustomerDTO())
                        )
                        .header("Authorization","Bearer " + generateAdminToken().getToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200, newResult.getResponse().getStatus());

    }
    @Test
    @Order(3)
    public void testCreateUserWentEmailAlreadyExists() throws Exception{
        try {
            var newResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                            .content(objectMapper.writeValueAsString(createCustomerDTO()))
                            .header("Authorization", "Bearer " + generateAdminToken().getToken())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            assertEquals(404, newResult.getResponse().getStatus());
        } catch (NestedServletException e) {
            Throwable rootCause = e.getRootCause();
        }

    }
    @Test
    @Order(3)
    public void testCreateUserWentPhoneNumberAlreadyExists() throws Exception{
        try {
            var newResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                            .content(objectMapper.writeValueAsString(createCustomerDTO2()))
                            .header("Authorization", "Bearer " + generateAdminToken().getToken())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            assertEquals(404, newResult.getResponse().getStatus());
        } catch (NestedServletException e) {
            Throwable rootCause = e.getRootCause();
        }

    }
    private CreateUsersDTO createCustomerDTO() {
        return CreateUsersDTO.builder()
                .firstName("luis")
                .lastName("andres")
                .email("johndo2@eemail.com")
                .phoneNumber("+5732586901880")
                .role("admin")
                .password("password").build();
    }
    private CreateUsersDTO createCustomerDTO2() {
        return CreateUsersDTO.builder()
                .firstName("luis")
                .lastName("andres")
                .email("johndo3@eemail.com")
                .phoneNumber("+5732586901880")
                .role("admin")
                .password("password").build();
    }

}
