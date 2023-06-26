package com.techCamp.backend.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.techCamp.backend.model.Rule;
import java.util.List;

@Repository
public class RuleRepository {

    private final MongoTemplate mongoTemplate;

    public RuleRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Rule findById(int id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Rule.class);
    }

    public List<Rule> findByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Rule.class);
    }

    public List<Rule> findAll() {
        return mongoTemplate.findAll(Rule.class);
    }

    public Rule save(Rule rule) {
        mongoTemplate.save(rule);
        return rule;
    }

    public Rule delete(Rule rule) {
        Query query = Query.query(Criteria.where("_id").is(rule.getId()));
        mongoTemplate.remove(query, Rule.class);
        return rule;
    }

}