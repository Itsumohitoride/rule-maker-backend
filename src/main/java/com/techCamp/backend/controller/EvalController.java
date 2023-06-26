package com.techCamp.backend.controller;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techCamp.backend.dto.KeyValueDto;
import com.techCamp.backend.service.EvalService;

@RestController
@RequestMapping("/evaluate")
public class EvalController {
    @Autowired
    EvalService evalService;

    @GetMapping("/{idRule}/{idTable}")
    public ResponseEntity<Boolean> update(@PathVariable int idRule,@PathVariable int idTable,@RequestBody KeyValueDto dto){
        return ResponseEntity.ok(evalService.evaluate(idRule, idTable, dto.getKey(), dto.getValue()));
    }


    
}
