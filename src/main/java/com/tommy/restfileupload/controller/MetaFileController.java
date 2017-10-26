package com.tommy.restfileupload.controller;


import com.tommy.restfileupload.entity.MetaFile;
import com.tommy.restfileupload.service.MetaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.PathParam;
import com.tommy.restfileupload.utility.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MetaFileController {
    @Autowired
    MetaFileService metaFileService;


    @RequestMapping(value = "/files", method = RequestMethod.POST)
    public ResponseEntity upload(@PathVariable(value = "file") MultipartFile file) throws IOException {
        MetaFile metaFile = FileStorageUtility.metaFileInit(file);
        metaFileService.uploadFile(file, metaFile);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public List<MetaFile> findAll(){
        List<MetaFile> fileList = metaFileService.getAllFiles();
            return fileList;
    }

    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
    public MetaFile findById(@PathVariable("id") Integer id){
        return metaFileService.getFileById(id);
    }
}
