package TestCases;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
		
		// Excel Sheet config
		
//		int rows=ExcelUtils.getRowCount(file, "Sheet1");
		
		
//		Properties propertie = new Properties();
//		propertie.load(new FileInputStream("./src/test/resources/config.properties"));
//		String url =propertie.getProperty("appurl");
		
		Locale usLocale =new Locale("en", "US");
		rb=ResourceBundle.getBundle("config" ,usLocale);  // Load config.properties file 
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//		
//		WebDriver driver = new ChromeDriver(options);
		
		driver =new ChromeDriver(options);
		
		driver.get(rb.getString("appurl"));
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\'BE_flight_paxInfoBox\']/span")).click();
		
		Thread.sleep(1000);
		
	    String selecttype = driver.findElement(By.xpath("//*[@id=\'BE_flight_form_wrapper\']/div[3]/div[1]")).getText();
		
//		String typeofflight =rb.getString("Flighttype");
		
		if (selecttype.contains(rb.getString("Flighttype"))) {
			driver.findElement(By.linkText(rb.getString("Flighttype"))).click();
		}
		
		driver.findElement(By.id("BE_flight_flsearch_btn")).click();
		
		Thread.sleep(5000);
		
        driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[1]/div/div[2]/div[7]/span")).click();
		
		Thread.sleep(2000);
		
		WebElement Price =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p"));
		
		Actions moveact =new Actions (driver);
		
//		WebElement scroller =driver.findElement(By.xpath("/html/body/section[2]/section/section[1]/div/div[2]/div/div/div[2]/div/div/div/div[2]"));
		
//		WebElement amount =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p/span[2]"));
		
		
//		moveact.dragAndDropBy(scroller, 0, 250).perform();
//		
//		WebElement amount =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p/span[2]"));
//		
//		String amountvalue=amount.getText();
//		
//		System.out.println(amountvalue);
		
		
//		WebElement numofstops =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[2]/div"));
//		
//		String stopscount =numofstops.getText();
//		
//		Thread.sleep(2000);
//		
//		if(stopscount.contains("2")) {
//			moveact.click(driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[2]/div/label[1]"))).perform();
//		}else {
//			driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[2]/div/label[2]/input")).click();
//		}
		
//		driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[4]/div/div[1]/input")).sendKeys("Vistara");
		
//		Thread.sleep(5000);
//		
		String selectcompany =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[4]/div/div[2]")).getText();
//		
//		String selectflightcompany =rb.getString("companyflight");
		
//		if (selectcompany.contains(rb.getString("companyflight"))) {
//			driver.findElement(By.linkText(rb.getString("companyflight"))).click();
//		}
	
//		
//		moveact.moveToElement(driver.findElement(By.xpath("//span[text()='selectflightcompany']"))).click().perform();
	
//		Thread.sleep(5000);
//		
//		driver.findElement(By.name("acfilter")).clear();
//		Thread.sleep(1000);

//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@value='Apply Filters']")).click();
//		
		// Yatra.com | Delhi to Mumbai flights
		
		String titleofpage =driver.getTitle();
		
		System.out.println(titleofpage);
		
		if(titleofpage.contains("Yatra.com | Delhi to Mumbai flights")) {
			
			System.out.println("Pass");
			
			ExcelUtils.setCellData(file, "Sheet1", 1, 0, "1");
			ExcelUtils.setCellData(file, "Sheet1", 1, 1, "sampletest");
			ExcelUtils.setCellData(file, "Sheet1", 1, 2, "Pass");
			ExcelUtils.fillGreenColor(file, "Sheet1",1,2);
			
		}else
		{
			
			System.out.println("Failed");
			ExcelUtils.setCellData(file, "Sheet1", 1, 0, "1");
			ExcelUtils.setCellData(file, "Sheet1", 1, 1, "sampletest");
			ExcelUtils.setCellData(file, "Sheet1",1,2,"Failed");
			ExcelUtils.fillRedColor(file, "Sheet1",1,2);
		}
	
		driver.close();
		driver.quit();
		
		
	}
	}
