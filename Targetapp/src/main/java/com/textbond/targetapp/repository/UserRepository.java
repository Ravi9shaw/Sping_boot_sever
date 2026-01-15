package com.textbond.targetapp.repository;

import com.textbond.targetapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
