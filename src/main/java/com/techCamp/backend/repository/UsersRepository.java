package com.techCamp.backend.repository;

import com.techCamp.backend.model.Rule;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UsersRepository {
    private final MongoTemplate mongoTemplate;


    public UsersRepository(MongoTemplate mt){
        this.mongoTemplate=mt;
    }
    public boolean findByEmail(String email) {
        Query query = Query.query(Criteria.where("email").is(email));
        return mongoTemplate.exists(query, User.class);
    }

    public boolean findByPhoneNumber(String phoneNumber) {
        Query query = Query.query(Criteria.where("phoneNumber").is(phoneNumber));
        return mongoTemplate.exists(query, User.class);
    }
    public Optional<User> getUserByEmail(String email) {
        Query query = Query.query(Criteria.where("email").is(email));
        User user = mongoTemplate.findOne(query, User.class);
        return Optional.ofNullable(user);
    }
    public User save(User user) {
        mongoTemplate.save(user);
        return user;
    }
}
