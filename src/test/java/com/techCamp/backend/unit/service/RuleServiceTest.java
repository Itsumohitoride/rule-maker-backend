package com.techCamp.backend.unit.service;

import com.techCamp.backend.dto.RuleDto;
import com.techCamp.backend.mapper.UserMapperImpl;
import com.techCamp.backend.repository.RuleRepository;
import com.techCamp.backend.repository.UsersRepository;
import com.techCamp.backend.service.RuleService;
import com.techCamp.backend.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class RuleServiceTest {
    private RuleRepository ruleRepository;
    private RuleService ruleService;
    @BeforeEach
    public void init() {
        ruleRepository = mock(RuleRepository.class);
        ruleService = new RuleService(ruleRepository);
    }
    @Test
    @Order(1)
    public void testCreateRule() {
        ruleService.save(ruleDto());
        verify(ruleRepository, times(1)).save(any());
        assertEquals("test", ruleDto().getName());
    }

    private RuleDto ruleDto(){
        return RuleDto.builder()
                .name("test")
                .rule("((name=Alexander)&((age>=19)&(state||true)))")
                .build();
    }

}
