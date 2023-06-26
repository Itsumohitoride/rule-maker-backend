package com.techCamp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techCamp.backend.dto.RuleDto;
import com.techCamp.backend.model.Rule;
import com.techCamp.backend.repository.RuleRepository;

@Service
public class RuleService {
    
    @Autowired
    RuleRepository ruleRepository;

    public List<Rule> getAll(){
        return ruleRepository.findAll();
    }

    public Rule getOne(int id){
        return ruleRepository.findById(id);
    }

    public Rule save(RuleDto dto){
        int id=autoIncrement();
        Rule ruleToSave=new Rule(id,dto.getName(),dto.getRule());
        ruleRepository.save(ruleToSave);
        return ruleToSave;
    }

    public Rule update(int id,RuleDto dto){
        Rule rule=ruleRepository.findById(id);
        rule.setName(dto.getName());
        rule.setRule(dto.getRule());
        return ruleRepository.save(rule);
    }

    public Rule delete(int id){
        Rule ruleTodelete=ruleRepository.findById(id);
        ruleRepository.delete(ruleTodelete);
        return ruleTodelete;
    }

    private int autoIncrement(){
        List<Rule> rules=ruleRepository.findAll();
        return rules.isEmpty() ? 1: rules.size()+1;
    }

}
