package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static String[][] getDataArrayFromExcel(String sheetName, String filePath)
			throws IOException {
		// Variables definition
		String[][] dataArray;
		String value;


		FileInputStream excelFile = new FileInputStream(filePath);

		XSSFWorkbook excelWorkBook = new XSSFWorkbook(excelFile);

		XSSFSheet excelWorkSheet = excelWorkBook.getSheet(sheetName);

		int totalRows = excelWorkSheet.getLastRowNum(); // Last index
		int totalCol = excelWorkSheet.getRow(0).getLastCellNum();

		// Initialize the array
		dataArray = new String[totalRows][totalCol];

		for (int i = 0; i < totalRows; i++) {
			XSSFRow currentRow = excelWorkSheet.getRow(i + 1);

			for (int j = 0; j < totalCol; j++) {
				Cell currentCell = currentRow.getCell(j);

				if (currentCell == null) {
					value = "";
				}
				else {
					value = currentRow.getCell(j).toString();
				}

				// Get a value to the place in the array
				dataArray[i][j] = value;
				System.out.print(" " + value);
			}

			System.out.println();
		}

		excelWorkBook.close();

		return (dataArray);
	}
}
