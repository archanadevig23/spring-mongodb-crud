package com.quinbay.springmongocrud.model;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class FileResponse {
    Integer id;
    Binary file;
}
