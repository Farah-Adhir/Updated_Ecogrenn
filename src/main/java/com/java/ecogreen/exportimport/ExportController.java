package com.java.ecogreen.exportimport;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import com.java.ecogreen.category.Category;
import com.java.ecogreen.category.CategoryRepository;

public class ExportController {

	  @Autowired
	    private CategoryRepository categoryRepository;

	    @Autowired
	    private ExcelGenerator excel;

	    @GetMapping("/export")
	    public ResponseEntity<InputStreamResource> excelStudentReport() throws Exception {
	        List<Category> studentList = categoryRepository.findAll();

	        ByteArrayInputStream in = excel.exportExcel(studentList);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=category.xlsx");

	        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

	    }
}
