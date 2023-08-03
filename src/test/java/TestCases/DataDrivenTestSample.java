package TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataDrivenTestSample {
	@Test
	public static void excelsheetupdate() throws IOException {

	FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\testdata\\TestCaseResult.xlsx");
	
	XSSFWorkbook workbook =new XSSFWorkbook(file);
	
	XSSFSheet sheet =workbook.getSheet("Sheet1");
	
	int totalrows=sheet.getLastRowNum();
	int totalcells =sheet.getRow(1).getLastCellNum();
	
	System.out.println("Number of Rows = "+totalrows);
	
	System.out.println("Number of Cells = "+totalcells);
	
	for(int r=0;r<=totalrows;r++) {
		XSSFRow currentRow=sheet.getRow(r);
		
		for(int c=0;c<totalcells;c++) {
			String value=currentRow.getCell(c).toString();
			System.out.println(value+"    ");
		}
		System.out.println(" ");
	}
	
	workbook.close();
	file.close();
	
	
	}
}
