package com.java.ecogreen.category;

import java.io.ByteArrayInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/import")
	public String createGetImport() {
		return "import";
	}

	@PostMapping("/import")
	public String createPostImport(@RequestParam(name = "file") MultipartFile file) throws Exception {
		categoryService.importExcel(file);
		 
		return "redirect:/import?success";
	}

	@GetMapping("/export")
	@ResponseBody
	public ResponseEntity<InputStreamResource> excelStudentReport() throws Exception {
		ByteArrayInputStream in = categoryService.exportExcel();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=category.xlsx");
		
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}
