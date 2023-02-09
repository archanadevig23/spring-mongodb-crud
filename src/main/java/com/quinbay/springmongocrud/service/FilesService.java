package com.quinbay.springmongocrud.service;

import com.quinbay.springmongocrud.model.Files;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface FilesService {
//    String fileUpload(MultipartFile file) throws IOException;
//    String fileUploadInMongo(MultipartFile multipartFile) throws IOException;
//    Optional<Files> fileDownload(Integer id) throws IOException;

    String addFile(MultipartFile multipartFile) throws IOException;
    Files downloadFile(String id) throws IOException;
}
