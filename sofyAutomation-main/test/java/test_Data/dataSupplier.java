 package test_Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataSupplier {
	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {
		
		File excelFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\dataDriven.xlsx");
		System.out.println(excelFile.exists());

		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int norws = sheet.getPhysicalNumberOfRows();
		int nocols = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[norws - 1][nocols];

		for (int i = 0; i < norws - 1; i++) {
			for (int j = 0; j < nocols; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
//				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
//				System.out.println(sheet.getRow(i).getCell(	j).getStringCellValue());
			}
		}

		workbook.close();
		fis.close();
//		for (String[] dataArr : data) {
//			System.out.println(Arrays.toString(dataArr));
//		}
		return data;
	}
}
