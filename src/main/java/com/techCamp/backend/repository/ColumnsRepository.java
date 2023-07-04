package com.techCamp.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.techCamp.backend.dto.ColumnDTO;
import com.techCamp.backend.model.Column;
import com.techCamp.backend.model.ColumnID;
import com.techCamp.backend.model.TableId;

@Repository
public class ColumnsRepository {
     private final MongoTemplate mongoTemplate;

    public ColumnsRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Column findById(ColumnID id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Column.class);
    }

    public List<Column> find(TableId tableId) {
        Query query = Query.query(Criteria.where("_id.tableId").is(tableId));
        return mongoTemplate.find(query, Column.class);
    }

    public List<Column> findAll() {
        return mongoTemplate.findAll(Column.class);
    }

    public Column save(Column column) {
        mongoTemplate.save(column);
        return column;
    }

    public Column delete(Column column) {
        Query query = Query.query(Criteria.where("_id").is(column.getId()));
        mongoTemplate.remove(query, Column.class);
        return column;
    }

    public Column update(ColumnID id,ColumnDTO toUpdate){
        Column column=findById(id);
        
        return column;
    }
}
