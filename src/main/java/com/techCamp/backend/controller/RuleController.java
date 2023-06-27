package com.techCamp.backend.controller;

import java.util.List;

import com.techCamp.backend.api.RuleAPI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techCamp.backend.dto.RuleDto;
import com.techCamp.backend.model.Rule;
import com.techCamp.backend.service.RuleService;

@RestController
@RequestMapping(RuleAPI.BASE_RULE_URL)
@AllArgsConstructor
public class RuleController implements RuleAPI {
    private final RuleService ruleService;

    @Override
    public List<Rule> getAll(){
        return ruleService.getAll();
    }

    @Override
    public Rule getOne(int id){
        return ruleService.getOne(id);
    }

    @Override
    public Rule save(RuleDto dto){
        System.out.println(dto.getName());
        return ruleService.save(dto);
    }

    @Override
    public Rule update(int id,@RequestBody RuleDto dto){
        return ruleService.update(id,dto);
    }

    @Override
    public Rule delete(int id){
        return ruleService.delete(id);
    }
}
