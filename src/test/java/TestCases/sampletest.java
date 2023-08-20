package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.ExcelUtils;

@Test
public class sampletest {
	
	
	public static WebDriver driver;
	public ResourceBundle rb;
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testsample() throws InterruptedException, IOException {
		
		String file =System.getProperty("user.dir")+"\\testdata\\OutputResult.xlsx";
		
		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excluseSwitches", new String[] {"enable-automation"});
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
				
		Locale usLocale =new Locale("en", "US");
		rb=ResourceBundle.getBundle("config" ,usLocale);  // Load config.properties file 
		
		driver =new ChromeDriver(options);
		
		driver.get(rb.getString("appurl"));
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//--------------------------------- Searching Bus with scrolling to end of the page--------------------------------------------
		
		driver.findElement(By.xpath("//a[@id='booking_engine_buses']")).click();
		
		Thread.sleep(1000);
		
        driver.findElement(By.xpath("//input[@id='BE_bus_from_station']")).click();
		
		WebElement busdep =driver.findElement(By.xpath("//input[@id='BE_bus_from_station']"));
		busdep.sendKeys(rb.getString("busdepstate"));
		Thread.sleep(2000);
		busdep.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement busarrive =driver.findElement(By.xpath("//input[@id='BE_bus_to_station']"));
		Thread.sleep(1000);
		busarrive.sendKeys(rb.getString("busarrivalstate"));
		Thread.sleep(1000);
		busarrive.sendKeys(Keys.ENTER);
		
		WebElement selectdateforbus =driver.findElement(By.xpath("//input[@id='BE_bus_depart_date']"));
		selectdateforbus.click();
		Thread.sleep(1000);
		driver.findElement(By.id(rb.getString("busdate"))).click();
		
		driver.findElement(By.xpath("//input[@id='BE_bus_search_btn']")).click();
		
		Thread.sleep(10000);
		
		// Double Click the Prize to arrange the amount as High to low
		
		WebElement prizearrange =driver.findElement(By.xpath("//*[@id=\'rowHeading\']/div[5]/i"));
		
		Actions action =new Actions(driver);
		
		action.doubleClick(prizearrange).build().perform();
		
		Thread.sleep(5000);
		
		// Scroll the page to some length down
		
		JavascriptExecutor scroll =(JavascriptExecutor) driver;
//		scroll.executeScript("window.scrollBy(0,50000)");
		
		// Scroll page to end of the page
		
		scroll.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		
		
		
		
			
		
//	    String selecttype = driver.findElement(By.xpath("//*[@id=\'BE_flight_form_wrapper\']/div[3]/div[1]")).getText();
//		
////		String typeofflight =rb.getString("Flighttype");
//		
//		if (selecttype.contains(rb.getString("Flighttype"))) {
//			driver.findElement(By.linkText(rb.getString("Flighttype"))).click();
//		}
//		
//		driver.findElement(By.id("BE_flight_flsearch_btn")).click();
//		
//		Thread.sleep(5000);
//		
//        driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[1]/div/div[2]/div[7]/span")).click();
//		
//		Thread.sleep(2000);
//		
//		WebElement Price =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p"));
//		
//		Actions moveact =new Actions (driver);
//		
////		WebElement scroller =driver.findElement(By.xpath("/html/body/section[2]/section/section[1]/div/div[2]/div/div/div[2]/div/div/div/div[2]"));
//		
////		WebElement amount =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p/span[2]"));
//		
//		
////		moveact.dragAndDropBy(scroller, 0, 250).perform();
////		
////		WebElement amount =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p/span[2]"));
////		
////		String amountvalue=amount.getText();
////		
////		System.out.println(amountvalue);
//		
//		
////		WebElement numofstops =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[2]/div"));
////		
////		String stopscount =numofstops.getText();
////		
////		Thread.sleep(2000);
////		
////		if(stopscount.contains("2")) {
////			moveact.click(driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[2]/div/label[1]"))).perform();
////		}else {
////			driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[2]/div/label[2]/input")).click();
////		}
//		
////		driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[4]/div/div[1]/input")).sendKeys("Vistara");
//		
////		Thread.sleep(5000);
////		
//		String selectcompany =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[4]/div/div[2]")).getText();
////		
////		String selectflightcompany =rb.getString("companyflight");
//		
////		if (selectcompany.contains(rb.getString("companyflight"))) {
////			driver.findElement(By.linkText(rb.getString("companyflight"))).click();
////		}
//	
////		
////		moveact.moveToElement(driver.findElement(By.xpath("//span[text()='selectflightcompany']"))).click().perform();
//	
////		Thread.sleep(5000);
////		
////		driver.findElement(By.name("acfilter")).clear();
////		Thread.sleep(1000);
//
////		Thread.sleep(5000);
////		driver.findElement(By.xpath("//input[@value='Apply Filters']")).click();
////		
//		// Yatra.com | Delhi to Mumbai flights
		
//		String titleofpage =driver.getTitle();
//		
//		System.out.println(titleofpage);
//		
//		if(titleofpage.contains("Yatra.com | Delhi to Mumbai flights")) {
//			
//			System.out.println("Pass");
//			
//			ExcelUtils.setCellData(file, "Sheet1", 1, 0, "1");
//			ExcelUtils.setCellData(file, "Sheet1", 1, 1, "sampletest");
//			ExcelUtils.setCellData(file, "Sheet1", 1, 2, "Pass");
//			ExcelUtils.fillGreenColor(file, "Sheet1",1,2);
//			
//		}else
//		{
//			
//			System.out.println("Failed");
//			ExcelUtils.setCellData(file, "Sheet1", 1, 0, "1");
//			ExcelUtils.setCellData(file, "Sheet1", 1, 1, "sampletest");
//			ExcelUtils.setCellData(file, "Sheet1",1,2,"Failed");
//			ExcelUtils.fillRedColor(file, "Sheet1",1,2);
//		}
	
//		driver.close();
//		driver.quit();
		
		
	}
	}
