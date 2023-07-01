package com.techCamp.backend.repository;

import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.model.TableId;

import java.util.List;

@Repository
public class TableRepository {

    private final MongoTemplate mongoTemplate;
    

    public TableRepository(MongoTemplate mt){
        this.mongoTemplate=mt;
    }

    public Table findById(TableId id) {
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

    public List<Table>findAllIngroup(String groupId){
        Query query = Query.query(Criteria.where("_id.groupId").is(groupId));
        return mongoTemplate.find(query, Table.class);
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

    public JSONObject updateInBy(Table table, String key, String value,JSONObject toUpdate) {
        Query query = new Query(Criteria.where("_id").is(table.getId()).and("data.myArrayList.map." + key).is(value));
        Update update = new Update().set("data.myArrayList.$", toUpdate);
        mongoTemplate.updateMulti(query, update, Table.class);
        return toUpdate;
    }
    
}