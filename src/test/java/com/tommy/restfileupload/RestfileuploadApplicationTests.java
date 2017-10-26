package com.tommy.restfileupload;

import com.tommy.restfileupload.controller.MetaFileController;
import com.tommy.restfileupload.dao.MetaFileDAO;
import com.tommy.restfileupload.entity.MetaFile;
import com.tommy.restfileupload.service.MetaFileService;
import com.tommy.restfileupload.service.MetaFileServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfileuploadApplicationTests {
	@Mock
	private MetaFileDAO metaFileDAO;

	@Mock
	private MetaFileService metaFileService;

	@InjectMocks
	private MetaFileController metaFileController;

	private MetaFile metaFile1, metaFile2;

	@Before
	public void testInit(){
		metaFile1 = new MetaFile();
		metaFile1.setFileId(1);
		metaFile1.setFileSize(1);
		metaFile1.setFileName("test1");
		metaFile1.setFilePath("/storage");
		metaFile2 = new MetaFile();
		metaFile2.setFileId(2);
		metaFile2.setFileSize(1);
		metaFile2.setFileName("test2");
		metaFile2.setFilePath("/storage");
	}

	@Test
	public void findByIdTest(){
		Mockito.when(metaFileService.getFileById(1)).thenReturn(metaFile1);
		Assert.assertEquals(metaFile1, metaFileController.findById(1));
	}

	@Test
	public void findAllTest(){
		List<MetaFile> metaFileList = new ArrayList<>();
		metaFileList.add(metaFile1);
		metaFileList.add(metaFile2);
		Mockito.when(metaFileService.getAllFiles()).thenReturn(metaFileList);
		Assert.assertEquals(metaFileList.size(), metaFileController.findAll().size());
	}
}
