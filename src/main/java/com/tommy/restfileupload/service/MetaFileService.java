package com.tommy.restfileupload.service;

import com.tommy.restfileupload.entity.MetaFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MetaFileService {
    public MetaFile getFileById(int id);

    public List<MetaFile> getAllFiles();

    public void uploadFile(MultipartFile file, MetaFile metaFile) throws IOException;

}
