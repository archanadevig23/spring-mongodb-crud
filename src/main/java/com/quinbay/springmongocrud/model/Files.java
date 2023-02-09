package com.quinbay.springmongocrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Generated;
import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class Files {
    @Id
    String id;
    String filename;
    String fileType;
    Date uploadDate;
    byte[] file;

    public Files(String id, String filename, byte[] file) throws IOException {
        this.id = id;
        this.uploadDate = new Date();
        this.filename = filename;
        this.file = file;
    }
}
