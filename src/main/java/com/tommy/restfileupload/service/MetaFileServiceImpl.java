package com.tommy.restfileupload.service;


import com.tommy.restfileupload.dao.MetaFileDAO;
import com.tommy.restfileupload.entity.MetaFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

import static com.tommy.restfileupload.utility.FileStorageUtility.*;

@Service
public class MetaFileServiceImpl implements MetaFileService{

    @Autowired
    MetaFileDAO metaFileDAO;

    @Override
    public MetaFile getFileById(int id) {
        return metaFileDAO.findOne(id);
    }

    @Override
    public List<MetaFile> getAllFiles() {
        return metaFileDAO.findAll();
    }

    @Override
    public void uploadFile(MultipartFile file, MetaFile metaFile) throws IOException {
        metaFileDAO.saveAndFlush(metaFileInit(file));
        try {
            save(file, metaFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
