package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Browser.variables;

public class Excel extends variables {
	// Using Excel for store Data
	public String readExcel(int row) {
		try {
			FileInputStream files = new FileInputStream(System.getProperty("user.dir")+"\\excel\\selenium.xlsx");
			workbook = new XSSFWorkbook(files);
			XSSFSheet sheet = workbook.getSheetAt(0);
			values = sheet.getRow(row).getCell(0).toString();
			workbook.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return values;
	}

	// Using Excel for store Data
	public void useExcel(String sheetname) {
		try {
			file = new File(excalpath);
			workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(sheetname);
			sheet.createRow(0).createCell(0).setCellValue("Pricelist");

			for (int i = 0; i < datas.size(); i++) {
				sheet.createRow(i + 1).createCell(0).setCellValue(datas.get(i).getText());
			}

			fileout = new FileOutputStream(file);
			workbook.write(fileout);
			workbook.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
