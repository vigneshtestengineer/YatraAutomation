package TestCases;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteDataExcel {
	@Test
	public static void ExcelDataUpdate() throws IOException {
		
		FileOutputStream excelfile =new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\OutputResult.xlsx");
		
		XSSFWorkbook workbook =new XSSFWorkbook();
		
		XSSFSheet sheet =workbook.createSheet();
		
		//Creating row,cell and update without loop
		
//		XSSFRow row1 =sheet.createRow(0);
//		
//		row1.createCell(0).setCellValue("Sl.No");
//		row1.createCell(1).setCellValue("TestCase ID");
//		row1.createCell(2).setCellValue("Result");
//		row1.createCell(3).setCellValue("Reason");
//		
//		XSSFRow row2 =sheet.createRow(1);
//		
//		row2.createCell(0).setCellValue("1");
//		row2.createCell(1).setCellValue("TC_001");
//		row2.createCell(2).setCellValue("Pass");
//		row2.createCell(3).setCellValue("Excel update testing");
		
		//Creating row,cell and update with loop
		
		Scanner sc=new Scanner(System.in);
		
		for(int r=0;r<=3;r++) {
			XSSFRow currentrow=sheet.createRow(r);
			
			for(int c=0;c<2;c++) {
				System.out.println("Enter the Value");
				String value=sc.next();
				currentrow.createCell(c).setCellValue(value);
			}
		}
		
		workbook.write(excelfile);
		workbook.close();
		excelfile.close();
		
		System.out.println("Writing is done................");
		
	}

}
