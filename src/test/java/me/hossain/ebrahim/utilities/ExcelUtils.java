package me.hossain.ebrahim.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static String username;
    public static String password;

    @SuppressWarnings({ "resource", "unused" })
    public void ReadExcel() throws IOException {
        String excelFilePath = "./testdata/testdata.xlsx";
        File file = new File(excelFilePath);
        System.out.println(file.getAbsolutePath());
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r = 1; r <= rows ; r++) {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < 1; c++) {
                XSSFCell cell = row.getCell(c);

                row = sheet.getRow(r);
                cell = row.getCell(c);
                username = cell.getStringCellValue();
                System.out.println(username);

                cell = row.getCell(c + 1);
                password = cell.getStringCellValue();
                System.out.println(password);
            }
        }
    }
}
