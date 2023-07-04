package com.techCamp.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.techCamp.backend.model.Group;
@Repository
public class GroupRepository {
    private final MongoTemplate mongoTemplate;

    public GroupRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Group findById(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Group.class);
    }

    public Group findByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Group.class);
    }

    public List<Group> findAll() {
        return mongoTemplate.findAll(Group.class);
    }

    public Group save(Group group) {
        mongoTemplate.save(group);
        return group;
    }

    public Group delete(Group group) {
        Query query = Query.query(Criteria.where("_id").is(group.getId()));
        mongoTemplate.remove(query, Group.class);
        return group;
    }
}
