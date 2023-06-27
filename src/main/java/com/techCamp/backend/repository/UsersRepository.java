package com.techCamp.backend.repository;

import com.techCamp.backend.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends MongoRepository<Users, UUID> {

    @Query(value = "SELECT CASE WHEN(COUNT(*) > 0) THEN true ELSE false END FROM Users u WHERE u.email = :email")
    boolean findByEmail(String email);

    @Query(value = "SELECT CASE WHEN(COUNT(*) > 0) THEN true ELSE false END FROM Users u WHERE u.phoneNumber = :phoneNumber")
    boolean findByPhoneNumber(String phoneNumber);

}
