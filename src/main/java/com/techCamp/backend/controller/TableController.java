package com.techCamp.backend.controller;

import java.util.List;


import com.techCamp.backend.api.TableAPI;
import com.techCamp.backend.dto.CRUDTableDto;
import com.techCamp.backend.dto.ColumnDTO;
import com.techCamp.backend.dto.CreateTableDTO;
import com.techCamp.backend.dto.RequestEvaluationDTO;
import lombok.AllArgsConstructor;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Column;
import com.techCamp.backend.model.ColumnID;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.model.TableId;
import com.techCamp.backend.service.TableService;


@RestController
@RequestMapping(TableAPI.BASE_TABLE_URL)
@AllArgsConstructor
public class TableController implements TableAPI {
    private final TableService tableService;

    @Override
    public Table getOne(String groupId, int tableId){
        TableId id=new TableId(tableId,groupId);
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
    public List<Table> getAll(String groupId){
        return tableService.getAll(groupId);
    }

    @Override
    public JSONObject updateInBy(CRUDTableDto dto) {
        TableId id=new TableId(dto.getTableId(),dto.getGroupId());
        return tableService.updateInBy(id, dto.getKey(), dto.getValue(), new JSONObject(dto.getToUpdate()));
    }

    @Override
    public JSONObject pushInBy(CRUDTableDto dto) {
        TableId id=new TableId(dto.getTableId(),dto.getGroupId());
        return tableService.pushInBy(id, new JSONObject(dto.getToUpdate()));
    }

    @Override
    public boolean removeInBy(CRUDTableDto dto) {
        TableId id=new TableId(dto.getTableId(),dto.getGroupId());
        return tableService.removeInBy(id, dto.getKey(), dto.getValue());
    }

    @Override
    public Column save(ColumnDTO dto) {
        return tableService.save(dto);
    }

    @Override
    public Column delete(ColumnID id) {
        return tableService.remove(id);
    }

    @Override
    public Column get( String groupId,  int tableId, String name) {
        TableId idTable=new TableId(tableId,groupId);
        ColumnID id=new ColumnID(idTable,name);
        return tableService.findOne(id);
    }

    @Override
    public List<Column> get(String groupId, int tableId) {
        TableId id=new TableId(tableId,groupId);
        return tableService.findColumns(id);
    }
    
}
