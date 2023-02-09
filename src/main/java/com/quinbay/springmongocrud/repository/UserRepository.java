package com.quinbay.springmongocrud.repository;

import com.quinbay.springmongocrud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
}
