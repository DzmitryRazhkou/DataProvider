package test.utility.ApachiPOI;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet("SignUp_TestData");

        } catch (IOException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void getCellData(int rowNum, int colNum) throws IOException {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(value);
    }

    public static void getRowCount() throws IOException {

        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of Rows: " + rowCount + " rows.");

    }
}
