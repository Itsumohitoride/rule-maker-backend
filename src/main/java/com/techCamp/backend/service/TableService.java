package com.techCamp.backend.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techCamp.backend.dto.CreateTableDTO;
import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.model.TableId;
import com.techCamp.backend.repository.TableRepository;
@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;

    public List<Table> getAll(){
        return tableRepository.findAll();
    }

    public Table getOne(TableId id){
        return tableRepository.findById(id);
    }

    public Table save(CreateTableDTO dto){
        int idTable = autoIncrement(dto.getGroupId());
        TableId id= new TableId(idTable,dto.getGroupId());
        Table table = new Table(id,dto.getTitle(),dto.getData());
        return tableRepository.save(table);
    }

    public Table update(TableId id,TableDto dto){
        Table table = tableRepository.findById(id);
        table.setData(dto.getData());
        table.setTitle(dto.getTitle());
        return tableRepository.save(table);
    }
    
    public Table delete(TableId id){
        Table table = tableRepository.findById(id);
        return tableRepository.delete(table);
    }

    public JSONObject findInBy(TableId id,String key,String value){
        Table table = tableRepository.findById(id);
        return tableRepository.searchInBy(table, key, value);
    }

    public JSONObject updateInBy(TableId id,String key,String value,JSONObject toUpdate){
        Table table = tableRepository.findById(id);
        return tableRepository.updateInBy(table, key, value,toUpdate);
    }

    public JSONObject pushInBy(TableId id,String key,String value,JSONObject toUpdate){
        Table table = tableRepository.findById(id);
        return tableRepository.pushInBy(table,toUpdate);
    }

    public boolean removeInBy(TableId id,String key,String value){
        Table table = tableRepository.findById(id);
        return tableRepository.removeInBy(table, key, value);
    }

    private int autoIncrement(String groupId){ 
        List<Table> tables = tableRepository.findAllIngroup(groupId);
        return tables.isEmpty() ? 1 : tables.size() + 1;
    }


}
