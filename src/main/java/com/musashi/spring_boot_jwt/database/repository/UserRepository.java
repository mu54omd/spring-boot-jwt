package com.musashi.spring_boot_jwt.database.repository;

import com.musashi.spring_boot_jwt.database.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByEmail(String email);
}
