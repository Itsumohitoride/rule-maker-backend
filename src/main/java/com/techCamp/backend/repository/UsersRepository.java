package com.techCamp.backend.repository;

import com.techCamp.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    @Query(value = "SELECT u FROM Users u WHERE u.email = :email")
    Optional<Users> findUserByEmail(String email);

    @Query(value = "SELECT CASE WHEN(COUNT(*) > 0) THEN true ELSE false END FROM Users u WHERE u.email = :email")
    boolean findByEmail(String email);

    @Query(value = "SELECT CASE WHEN(COUNT(*) > 0) THEN true ELSE false END FROM Users u WHERE u.phoneNumber = :phoneNumber")
    boolean findByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT c FROM Users c WHERE c.customerId = :idNumber")
    Optional<Users> getCustomerById(UUID idNumber);
}
