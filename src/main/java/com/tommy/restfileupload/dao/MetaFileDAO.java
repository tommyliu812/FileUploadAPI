package com.tommy.restfileupload.dao;

import com.tommy.restfileupload.entity.MetaFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaFileDAO extends JpaRepository<MetaFile, Integer>{
}
