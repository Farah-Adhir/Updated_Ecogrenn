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

    /* export */
    public ByteArrayInputStream exportExcel(List<Category> categories) throws Exception {
        String[] columns = {"cat_id", "cat_name", "cat_type"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Category");
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            //Row of Header
            Row headerRow = sheet.createRow(0);

            //Header
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }


            int rowIdx = 1;
            for (Category category : categories) {
                Row row = sheet.createRow(rowIdx);

                row.createCell(0).setCellValue(category.getCat_id());
                row.createCell(1).setCellValue(category.getCat_name());
                row.createCell(2).setCellValue(category.getCat_type());
              
                rowIdx++;
            }

            workbook.write(out);
            workbook.close();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {

        }
        return null;
    }

    /* Import */
    public void importExcel(MultipartFile file) throws Exception {

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < (CountRowExcel(sheet.rowIterator())); i++) {
            if (i == 0) {
                continue;
            }

            Row row = sheet.getRow(i);
			/* id = row.getCell(0).getIntegerCellValue(); */
            String cat_name = row.getCell(1).getStringCellValue();
            String cat_type = row.getCell(2).getStringCellValue();
           

            categoryRepository.save(new Category(0, cat_name, cat_type));
        }

    }

    /* Count Row of Excel Table */
    public static int CountRowExcel(Iterator<Row> iterator) {
        int size = 0;
        while (iterator.hasNext()) {
            Row row = iterator.next();
            size++;
        }
        return size;
    }

}
