package com.quinbay.springmongocrud.controller;

import com.quinbay.springmongocrud.model.Files;
import com.quinbay.springmongocrud.serviceimpl.FilesServiceImpl;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    FilesServiceImpl filesServiceImpl;

    Logger logger = LoggerFactory.getLogger("Files Controller Logger");

    @PostMapping(value = "/addFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addFile(@RequestParam MultipartFile multipartFile) throws IOException {
        return filesServiceImpl.addFile(multipartFile);
    }

    @GetMapping(("/downloadFile"))
    public ResponseEntity<ByteArrayResource> downloadFile(String id) throws IOException {
        Files file = filesServiceImpl.downloadFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(new ByteArrayResource(file.getFile()));
//        return filesServiceImpl.downloadFile(id);
    }


//    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//        logger.info(multipartFile.getOriginalFilename());
//        return filesServiceImpl.fileUpload(multipartFile);
//    }
//
//    @PostMapping(value = "/uploadFileInMongo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String fileUploadInMongo(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//        logger.info(multipartFile.getOriginalFilename());
//        return null;
////        return filesServiceImpl.fileUploadInMongo(multipartFile);
//    }

//    @GetMapping("/getFiles")
//    public String fileDownload(@RequestParam Integer id, Model model) {
//        logger.info(filesServiceImpl.fileDownload(id).get().toString());
//        if(filesServiceImpl.fileDownload(id) != null) {
//            Files files = filesServiceImpl.fileDownload(id).get();
//            logger.info("Filename - " + files.getFilename());
//            model.addAttribute("title", files.getFilename());
//            model.addAttribute("file", Base64.getEncoder().encodeToString(files.getFile().getData()));
//            logger.info("Model title - " + model.getAttribute("title"));
//            return "File present";
//        }
//        else
//            return "File not found";
//    }

//    @GetMapping("/getFiles")
//    public String fileDownload(@RequestParam Integer id) throws IOException {
//        logger.info(filesServiceImpl.fileDownload(id).get().toString());
//        if(filesServiceImpl.fileDownload(id) != null) {
//            Files files = filesServiceImpl.fileDownload(id).get();
////            files.getFile().transferTo(new File("/Users/archanadevi/Documents/BliKanvas/spring-mongo-crud/downloaded/"+files.getFilename()));
//            logger.info("Filename - " + files.getFilename());
//            logger.info("File - " + files.getFile());
////            logger.info("Downloaded file name - " + );
//            return "File present";
//        }
//        else
//            return "File not found";
//    }

}
