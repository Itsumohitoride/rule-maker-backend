package com.techCamp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.techCamp.backend.dto.RuleDto;
import com.techCamp.backend.model.Rule;
import com.techCamp.backend.service.RuleService;

@RestController
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    RuleService ruleService;

    @GetMapping
    public ResponseEntity<List<Rule>> getAll(){
        return ResponseEntity.ok(ruleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rule> getOne(@PathVariable int id){
        return ResponseEntity.ok(ruleService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Rule> save(@RequestBody RuleDto dto){
        System.out.println(dto.getName());
        return ResponseEntity.ok(ruleService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rule> update(@PathVariable int id,@RequestBody RuleDto dto){
        return ResponseEntity.ok(ruleService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rule> delete(@PathVariable int id){
        return ResponseEntity.ok(ruleService.delete(id));
    }


}
