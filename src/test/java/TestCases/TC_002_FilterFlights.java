package TestCases;

import javax.xml.xpath.XPath;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.FilterFlights;
import PageObject.MoreFilter;

import TestBase.BaseClass;
import utilities.ExcelUtils;

public class TC_002_FilterFlights extends BaseClass {
	
	
	String file =System.getProperty("user.dir")+"\\testdata\\OutputResult.xlsx";
	
	XSSFWorkbook workbook =new XSSFWorkbook();
	
	@Test
	void Filter_Flight(){
		logger.debug("*** Log Info ***");
		
		logger.info("______________Starting TC_002_FilterFlights___________________ ");
		
		try {
			
			FilterFlights FF =new FilterFlights(driver);
			MoreFilter MF=new MoreFilter(driver);
			Thread.sleep(5000);
//			FF.closepopupbox();
			FF.selectfromtostate();
			FF.selecttostate();
			FF.selecttraveldate();
			FF.selecttravelerdetails();
			MF.clickmorefilter();
			
			Thread.sleep(5000);
			
			String passorfail =driver.findElement(By.xpath("//div[@class='pr applied-filter wr-hr-center wr-width mt-10']")).getText();
			
			if(passorfail.contains("Vistara Business")) {
				
				System.out.println("Pass");
				
				ExcelUtils.setCellData(file, "Sheet1", 1, 0, "1");
				ExcelUtils.setCellData(file, "Sheet1", 1, 1, "TC_002_FilterFlights");
				ExcelUtils.setCellData(file, "Sheet1", 1, 2, "Pass");
				ExcelUtils.fillGreenColor(file, "Sheet1",1,2);
				
			}else
			{
				
				System.out.println("Failed");
				ExcelUtils.setCellData(file, "Sheet1", 1, 0, "1");
				ExcelUtils.setCellData(file, "Sheet1", 1, 1, "TC_002_FilterFlights");
				ExcelUtils.setCellData(file, "Sheet1",1,2,"Failed");
				ExcelUtils.fillRedColor(file, "Sheet1",1,2);
			}
			
		} catch(Exception e) {
	
			Assert.fail("Failed");
		}


}

	
}
