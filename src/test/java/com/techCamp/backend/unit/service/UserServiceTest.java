package com.techCamp.backend.unit.service;

import com.techCamp.backend.dto.CreateUsersDTO;
import com.techCamp.backend.dto.ResponseUserDTO;
import com.techCamp.backend.mapper.UserMapper;
import com.techCamp.backend.mapper.UserMapperImpl;
import com.techCamp.backend.model.User;
import com.techCamp.backend.repository.UsersRepository;
import com.techCamp.backend.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UsersService usersService;
    private UsersRepository usersRepository;
    private UserMapper userMapper;
    private PasswordEncoder encoder;

    @BeforeEach
    public void init() {
        usersRepository = mock(UsersRepository.class);
        encoder = mock(PasswordEncoder.class);
        userMapper = spy(UserMapperImpl.class);
        usersService = new UsersService(encoder,usersRepository, userMapper);
    }

    @Test
    @Order(1)
    public void testCreateResponseCustomer() {
        when(usersRepository.findByEmail(any())).thenReturn(false);
        when(usersRepository.findByPhoneNumber(any())).thenReturn(false);
        when(usersRepository.save(any())).thenReturn(defaultUser());
        when(userMapper.fromUserToResponseUserDTO(any())).thenReturn(defaultResponseUserDTO());
        usersService.save(createCustomerDTO());
        assertEquals("lucho@email.com", defaultResponseUserDTO().getEmail());
        verify(usersRepository, times(1)).save(any());

    }
    private User defaultUser() {
        return User.builder().firstName("luis").lastName("andres").email("lucho@email.com").password("password").phoneNumber("332036584").role("admin").build();
    }

    private ResponseUserDTO defaultResponseUserDTO() {
        return ResponseUserDTO.builder().firstName("luis").lastName("andres").email("lucho@email.com").phoneNumber("332036584").role("Admin").build();
    }
    private CreateUsersDTO createCustomerDTO() {
        return CreateUsersDTO.builder().firstName("luisa").lastName("andrea").phoneNumber("332036584").role("Admin").password("password").build();
    }
    @Test
    @Order(3)
    public void testCreateResponseCustomerWentEmailAlreadyExist() {


        try {
            when(usersRepository.findByEmail(any())).thenReturn(true);
            when(usersRepository.findByPhoneNumber(any())).thenReturn(false);
            when(usersRepository.save(any())).thenReturn(defaultUser());
            when(userMapper.fromUserToResponseUserDTO(any())).thenReturn(defaultResponseUserDTO());
            usersService.save(createCustomerDTO());
        } catch (RuntimeException exception) {
            assertEquals("A user with the entered email already exists.", exception.getMessage());
        }


    }

    @Test
    @Order(4)
    public void testCreateResponseCustomerWentPhoneNumberAlreadyExist() {
        try {
            when(usersRepository.findByPhoneNumber(any())).thenReturn(true);
            when(usersRepository.findByEmail(any())).thenReturn(false);
            when(usersRepository.save(any())).thenReturn(defaultUser());
            when(userMapper.fromUserToResponseUserDTO(any())).thenReturn(defaultResponseUserDTO());
            usersService.save(createCustomerDTO());


        } catch (RuntimeException exception) {

            assertEquals("A user with the entered phone already exists.", exception.getMessage());
        }


    }

}
