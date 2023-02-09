package com.quinbay.springmongocrud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    Integer userId;
    String name;
    String email;
}
