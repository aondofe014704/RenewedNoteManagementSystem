package com.semicolon.africa.contactmanagementsystem.data.repository;

import com.semicolon.africa.contactmanagementsystem.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
