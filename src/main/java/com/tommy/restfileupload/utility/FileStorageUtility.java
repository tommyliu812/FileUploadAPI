package com.tommy.restfileupload.utility;

import com.tommy.restfileupload.entity.MetaFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileStorageUtility {

    @Autowired
    public MetaFile metaFile;

    static final String PATH = System.getProperty("user.dir");

    public static MetaFile metaFileInit(MultipartFile file){
        MetaFile metaFile = new MetaFile();
        metaFile.setFileName(file.getOriginalFilename());
        metaFile.setFileSize((int) file.getSize());
        metaFile.setFilePath((new File(PATH).getAbsolutePath() + "/storage/" + file.getOriginalFilename()));
        return metaFile;

    }

    public static void save(MultipartFile file, MetaFile metaFile) throws IOException {
        try {
            file.transferTo(new File(metaFile.getFilePath()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
