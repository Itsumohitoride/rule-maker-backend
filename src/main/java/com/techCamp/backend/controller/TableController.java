package com.techCamp.backend.controller;

import java.util.List;

import com.techCamp.backend.api.TableAPI;
import com.techCamp.backend.dto.CreateTableDTO;
import com.techCamp.backend.dto.RequestEvaluationDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.model.TableId;
import com.techCamp.backend.service.TableService;


@RestController
@RequestMapping(TableAPI.BASE_TABLE_URL)
@AllArgsConstructor
public class TableController implements TableAPI {
    private final TableService tableService;

    @Override
    public Table getOne(TableId id){
        return tableService.getOne(id);
    }

    @Override
    public Table save(CreateTableDTO dto){
        return tableService.save(dto);
    }

    @Override
    public Table update(TableDto dto){
        return tableService.update(dto.getId(),dto);
    }

    @Override
    public Table delete(TableId id){
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
