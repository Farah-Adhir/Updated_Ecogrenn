package com.java.ecogreen.category;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ExportController {
	 @Autowired
	    private CategoryRepository studentRepository;

	    @Autowired
	    private CategoryService excel;

	    @GetMapping("/export")
	    public ResponseEntity<InputStreamResource> excelStudentReport() throws Exception {
	        List<Category> cat_list = studentRepository.findAll();

	        ByteArrayInputStream in = excel.exportExcel(cat_list);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=category.xlsx");

	        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	    }

}
