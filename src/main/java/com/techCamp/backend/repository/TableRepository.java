package com.techCamp.backend.repository;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;

import java.util.Map;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techCamp.backend.model.Table;
import java.util.List;

@Repository
public class TableRepository {

    private final MongoTemplate mongoTemplate;
    

    public TableRepository(MongoTemplate mt){
        this.mongoTemplate=mt;
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

    public JSONObject searchInBy(Table table, String key, String value) {
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("_id").is(table.getId())), 
            Aggregation.unwind("data.myArrayList"),
            Aggregation.match(Criteria.where("data.myArrayList.map." + key).is(value))
        );
        List<JSONObject> results = mongoTemplate.aggregate(aggregation, "tables", JSONObject.class).getMappedResults();
        for(JSONObject jsObject:results){
            JSONObject jsData=(JSONObject)jsObject.get("data");
            JSONObject jsArray=(JSONObject)jsData.get("myArrayList");
            JSONObject jsMap=(JSONObject)jsArray.get("map");
            return jsMap;
        }
        return null;
    }
}