package com.quinbay.springmongocrud.serviceimpl;

import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.quinbay.springmongocrud.model.FileResponse;
import com.quinbay.springmongocrud.model.Files;

import com.quinbay.springmongocrud.repository.FilesRepository;
import com.quinbay.springmongocrud.service.FilesService;
import org.apache.commons.io.IOUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class FilesServiceImpl implements FilesService  {

    Logger logger = LoggerFactory.getLogger("Files Service Logger");

    int id = 4;

    @Autowired
    FilesRepository filesRepository;

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    public String addFile(MultipartFile multipartFile) throws IOException {
        Object fileId = template.store(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), multipartFile.getContentType());
        return fileId.toString();
    }


    public Files downloadFile(String id) throws IOException{
        GridFSFile gridFSFile = template.findOne(new Query(Criteria.where("_id").is(id)));
        Files files = new Files();
        if(gridFSFile!=null) {
            files.setFilename(gridFSFile.getFilename());
            files.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );
            files.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getContent()) );
        }
        return files;
    }


//    @Override
//    public String fileUpload(MultipartFile multipartFile) throws IOException {
//        File file = new File("/Users/archanadevi/Documents/BliKanvas/spring-mongo-crud/files/"+multipartFile.getOriginalFilename());
//        file.createNewFile();
//        logger.info("File name - " + file.getPath());
//        try (FileOutputStream fout = new FileOutputStream(file)){
//            logger.info("Fout - " + fout);
//            fout.write(multipartFile.getBytes());
//            logger.info("File data - " + file.getName() + " " + file);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "File uploaded successfully!";
//    }

//    @Override
//    public String fileUploadInMongo(MultipartFile multipartFile) throws IOException {
//
//        Files newFile = new Files(id, multipartFile.getOriginalFilename(),multipartFile);
//        logger.info("Line 53 : " + newFile.getFilename());
//        id++;
//        try {
//            logger.info("File data - " + newFile);
//            filesRepository.save(newFile);
//            logger.info("Message");
//            logger.info(newFile.getId().toString());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "File uploaded successfully!";
//    }

//    public Optional<Files>  fileDownload(Integer id){
//        logger.info("Returned - " + filesRepository.findById(id).get().getFilename());
//        if(filesRepository.findById(id).isPresent())
//            return filesRepository.findById(id);
//        else
//            return null;
//        try {
//            Optional<Files> file = filesRepository.findById(id);
//            FileResponse fileResponse = new FileResponse();
//            fileResponse.setId(id);
//            fileResponse.setFile(file.get().getFile());
//            model.addAttribute("title", file.get().getFilename());
//            model.addAttribute("file", Base64.getEncoder().encodeToString(file.get().getFile().getData()));
//            return "File present";
//        } catch (Exception e) {
//
//        }
//        return null;
}