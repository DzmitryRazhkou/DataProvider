package test.utility.ApachiPOI;

import java.io.IOException;

public class ExcelUtilsTest {
    public static void main(String[] args) throws IOException {

        String project_Dir = System.getProperty("user.dir");  // /Users/dzmitryrazhkou/Documents/Automation/DataDrivenFramework/DataProvider
        String excelPath = project_Dir + "/src/test/java/test/utility/data_sheet.xls";
        String sheetName = "SignUp_TestData";

        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

        ExcelUtils.getRowCount();
        ExcelUtils.getCellData(1,0);
        ExcelUtils.getCellData(1,1);
        ExcelUtils.getCellData(1,2);

    }
}
