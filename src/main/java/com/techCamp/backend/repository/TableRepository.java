package com.techCamp.backend.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.techCamp.backend.model.Table;
import java.util.List;

@Repository
public class TableRepository {

    private final MongoTemplate mongoTemplate;

    public TableRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Table findById(int id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Table.class);
    }

    public List<Table> findByTitle(String title) {
        Query query = Query.query(Criteria.where("title").is(title));
        return mongoTemplate.find(query, Table.class);
    }

    public List<Table> findAll() {
        return mongoTemplate.findAll(Table.class);
    }

    public Table save(Table table) {
        mongoTemplate.save(table);
        return table;
    }

    public Table delete(Table table) {
        Query query = Query.query(Criteria.where("_id").is(table.getId()));
        mongoTemplate.remove(query, Table.class);
        return table;
    }

    // Otros métodos de repositorio

}