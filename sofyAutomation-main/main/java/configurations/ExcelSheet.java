package configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	public File src;
	public FileInputStream fis;
	public XSSFWorkbook xsf;
	public XSSFSheet sheet;
	public String ces;

	// Class will be updated if required
	public ExcelSheet() {

		src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Sheet.xlsx");

		try {
//			FileInputStream fis = new FileInputStream(src);

//			XSSFWorkbook xsf = new XSSFWorkbook(fis);

//			XSSFSheet sheet = xsf.getSheet("Amigo");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateResult(String testCaseName, String qwerty) throws Exception {
		// Write Data
		int totalRow = sheet.getLastRowNum() + 1;
		for (int i = 1; i < totalRow; i++) {
			XSSFRow r = sheet.getRow(i);
			String ce = r.getCell(1).getStringCellValue();
			if (ce.contains(testCaseName)) {
				r.createCell(2).setCellValue(qwerty);
				fis.close();
				FileOutputStream outFile = new FileOutputStream(
						new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Sheet.xlsx"));
				xsf.write(outFile);
				xsf.close();
				outFile.close();
				break;
			}
			}
		}

//	public String getData(String Testcaseid) throws IOException {
//		int totalRow = sheet.getLastRowNum() + 1;
//		for (int i = 1; i < totalRow; i++) {
//			XSSFRow r = sheet.getRow(i);
//			String ce = r.getCell(0).getStringCellValue();	
//			if (ce.contains(Testcaseid)) {
//			String ces = r.getCell(totalRow+1).getStringCellValue();
//			fis.close();
//			xsf.close();}
//		}
//		return ces;
//}
}
