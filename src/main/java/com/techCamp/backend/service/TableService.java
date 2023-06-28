package com.techCamp.backend.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.repository.TableRepository;
@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;

    public List<Table> getAll(){
        return tableRepository.findAll();
    }

    public Table getOne(int id){
        return tableRepository.findById(id);
    }

    public Table save(TableDto dto){
        int id = autoIncrement();
        Table table = new Table(id,dto.getTitle(),dto.getData());
        return tableRepository.save(table);
    }

    public Table update(int id,TableDto dto){
        Table table = tableRepository.findById(id);
        table.setData(dto.getData());
        table.setTitle(dto.getTitle());
        return tableRepository.save(table);
    }
    
    public Table delete(int id){
        Table table = tableRepository.findById(id);
        return tableRepository.delete(table);
    }

    public JSONObject findInBy(int id,String key,String value){
        Table table = tableRepository.findById(id);
        return tableRepository.searchInBy(table, key, value);
    }

    private int autoIncrement(){ 
        List<Table> tables = tableRepository.findAll();
        return tables.isEmpty() ? 1 : tables.size() + 1;
    }
}
