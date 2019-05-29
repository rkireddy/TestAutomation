package testnglearning;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterizationHashMap {
	public static ExcelReader excel = null;

	@Test(dataProvider = "getData")
	public void loginTest(HashMap<String,String> data) {

		System.out.println(data.get("username") + " -- - -- " + data.get("password") + " -- - -- " + data.get("age")
				+ " -- - -- " + data.get("location"));
	}

	@DataProvider
	public static Object[][] getData() {

		if (excel == null) {
			excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
		}

		String sheetName = "LoginTest";
 		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		Map<String, String> map = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			map = new HashMap<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				map.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = map;
			}
		}
		return data;

	}
}
