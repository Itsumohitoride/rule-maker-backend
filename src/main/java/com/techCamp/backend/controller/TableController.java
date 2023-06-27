package com.techCamp.backend.controller;

import java.util.List;

import com.techCamp.backend.api.TableAPI;
import com.techCamp.backend.dto.RequestEvaluationDTO;
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

import static com.techCamp.backend.api.TableAPI.BASE_TABLE_URL;

@RestController
@RequestMapping(BASE_TABLE_URL)
public class TableController implements TableAPI {
    TableService tableService;

    @Override
    public Table getOne(int id){
        return tableService.getOne(id);
    }

    @Override
    public Table save(TableDto dto){
        return tableService.save(dto);
    }

    @Override
    public Table update(int id, TableDto dto){
        return tableService.update(id, dto);
    }

    @Override
    public Table delete(int id){
        return tableService.delete(id);
    }

    @Override
    public String searchInBy(RequestEvaluationDTO evaluation){
        return tableService.findInBy(evaluation.getTableId(), evaluation.getKey(), evaluation.getValue()).toString();
    }

    @Override
    public List<Table> getAll(){
        return tableService.getAll();
    }
}
