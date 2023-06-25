package com.techCamp.backend.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.service.TableService;

@RestController
@RequestMapping("/table")
public class TableController {
    
    @Autowired
    TableService tableService;

    @GetMapping
    public ResponseEntity<List<Table>> getAll(){
        return ResponseEntity.ok(tableService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JSONObject> getOne(@PathVariable("id") int id){
        JSONObject object=new JSONObject(tableService.getOne(id));
        return ResponseEntity.ok(object);
    }

    @PostMapping
    public ResponseEntity<Table> save(@RequestBody TableDto dto){
        return ResponseEntity.ok(tableService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Table> update(@PathVariable("id") int id,@RequestBody TableDto dto){
        return ResponseEntity.ok(tableService.update(id,dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Table> delete(@PathVariable("id") int id){
        return ResponseEntity.ok(tableService.delete(id));
    }

}