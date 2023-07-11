package com.java.ecogreen.category;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class CategoryService {
@Autowired
    private CategoryRepository categoryRepository;

    public ByteArrayInputStream exportExcel() throws Exception {
        String[] columns = {"#", "cat_name", "cat_type"};
        List<Category> categories= categoryRepository.findAllByOrderByCatIdAsc();
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            
            Sheet sheet = workbook.createSheet("Category");
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }
            
            int rowIdx = 1;
            for (Category category : categories) {
                Row row = sheet.createRow(rowIdx);

                row.createCell(0).setCellValue(rowIdx);
                row.createCell(1).setCellValue(category.getCatName());
                row.createCell(2).setCellValue(category.getCatType());
              
                rowIdx++;
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    public void importExcel(MultipartFile file) throws Exception {

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        
        Iterator<Row> iterator =sheet.rowIterator();
        iterator.next();//skipping header
        while (iterator.hasNext()) {
            Row row = iterator.next();
			/* id = row.getCell(0).getIntegerCellValue(); */
            String catName = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "";
            String catType = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "";

            Category category=new Category();
            category.setCatName(catName);
            category.setCatType(catType);
            categoryRepository.save(category);
        }

    }

    

}
