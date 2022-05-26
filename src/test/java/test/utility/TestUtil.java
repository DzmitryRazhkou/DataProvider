package test.utility;

import java.util.ArrayList;

public class TestUtil {
    static Xls_Reader reader;

public static ArrayList<Object[]> getDataFromExcel() {

    String excelPath = "/Users/dzmitryrazhkou/Documents/Automation/DataDrivenFramework/DataProvider" +
            "/src/test/java/test/utility/data_sheet.xls";
    String sheetName = "SignUp_TestData";

    ArrayList<Object[]> myData = new ArrayList<>();
    try {
        reader = new Xls_Reader(excelPath);
    } catch (Exception e) {
        e.printStackTrace();
    }

    for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
        String firstname = reader.getCellData(sheetName,"firstname", rowNum);
        String lastname = reader.getCellData(sheetName,"lastname", rowNum);
        String email = reader.getCellData(sheetName,"email", rowNum);
        String password = reader.getCellData(sheetName,"password", rowNum);

        Object ob[] = {firstname, lastname, email, password};
        myData.add(ob);
    }

    return myData;

    }
}
