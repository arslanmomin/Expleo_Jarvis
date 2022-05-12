package jarvis.dataproviders;

import utilities.ExcelLibrary;
public class DataProvider {
	
	ExcelLibrary el= new ExcelLibrary();
	
	@org.testng.annotations.DataProvider(name="credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = el.getRowCount("Login");
		// Total Columns
		int column = el.getColumnCount("Login");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = el.getCellData("Login", j, i + 2);
			}
		}
		return data;
	}

}
