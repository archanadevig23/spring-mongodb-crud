package com.quinbay.springmongocrud.repository;

import com.quinbay.springmongocrud.model.Files;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilesRepository extends MongoRepository<Files, Integer> {
}
