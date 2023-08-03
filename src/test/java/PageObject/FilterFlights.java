package PageObject;

import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import TestBase.BaseClass;

public class FilterFlights extends BaseClass{
	
	public FilterFlights(WebDriver driver) {
		super();
	}
	
	
	
	@Test
	public void closepopupbox() throws InterruptedException {
		
		logger.info("Popup is Closed");
		
		
		Thread.sleep(10000);
		
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		Thread.sleep(5000);
		driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
	
	}
	
	@Test(priority = 1)
	
	public void selectfromtostate() throws InterruptedException {
		Locale usLocale =new Locale("en", "US");
		rb=ResourceBundle.getBundle("config" ,usLocale);  // Load config.properties file 
		
		Thread.sleep(2000);
		
		WebElement clickfrom = driver.findElement(By.name("flight_origin"));
		
		clickfrom.click();
		
		Thread.sleep(2000);
		
		clickfrom.sendKeys(rb.getString("fromstate"));
		
		Thread.sleep(1000);
		
		clickfrom.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

	}
	
	@Test(priority = 2)
	
	public void selecttostate() throws InterruptedException {
		
		WebElement tostate =driver.findElement(By.name("flight_destination"));
		
		Thread.sleep(1000);
		
		tostate.sendKeys(rb.getString("tostate"));

		Thread.sleep(2000);
		tostate.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
	}
	
	@Test(priority = 3)
	
	public void selecttraveldate() throws InterruptedException {
		WebElement selectdatepicker =driver.findElement(By.xpath("//*[@id=\'BE_flight_origin_date\']"));
		
		selectdatepicker.click();
		
		Thread.sleep(1000);
		
		WebElement selectdate =driver.findElement(By.id(rb.getString("dateofbook")));
		selectdate.click();
		
		Thread.sleep(1000);
	}
	
	@Test(priority = 4)
	
	public void selecttravelerdetails() throws InterruptedException {
		
		Thread.sleep(1000);
		
		//-------------------------Selecting the passengers count-----------------
		
		driver.findElement(By.xpath("//*[@id=\'BE_flight_paxInfoBox\']/span")).click();
		
		Thread.sleep(1000);
		
		//-------------------------Selecting Adults--------------------------------
		
		String j= rb.getString("numberofadults");
		
		int M=Integer.parseInt(j);
	
		for(int i=1;i<M;i++) {
		
		WebElement clickplus =driver.findElement(By.xpath("//*[@id=\'BE_flight_passengerBox\']/div[1]/div[1]/div/div/span[2]"));
		
		clickplus.click();
		}
		
		
		//------------------------------Selecting the Class of Flights----------------------------
				
		
		WebElement Economybtn = driver.findElement(By.xpath("//*[@id=\'flight_class_select_child\']/ul/li[1]"));
		String Textofecoclass =Economybtn.getText();
		
		WebElement Premiumbtn =driver.findElement(By.xpath("//*[@id=\'flight_class_select_child\']/ul/li[2]"));
		String Textofpriclass =Premiumbtn.getText();
		
		WebElement Businessbtn =driver.findElement(By.xpath("//*[@id=\'flight_class_select_child\']/ul/li[3]"));
		
		String classofairbus =rb.getString("airlineclass");
		
		if(Textofecoclass.contains("classofairbus")) {
			
			Economybtn.click();
			
		}else if(Textofpriclass.contains("classofairbus")) {
			Premiumbtn.click();
		}else {
			Businessbtn.click();
		}
			
		
		
		//------------------------Selecting the Non stop or Student or Armed force or Senior citizen----------------
		Thread.sleep(1000);
		
		String selecttype = driver.findElement(By.xpath("//*[@id=\'BE_flight_form_wrapper\']/div[3]/div[1]")).getText();
		
		if (selecttype.contains(rb.getString("Flighttype"))) {
			driver.findElement(By.linkText(rb.getString("Flighttype"))).click();
		}

		
		//------------------------------Click Search Flight button--------------------------------------------------
		
		driver.findElement(By.id("BE_flight_flsearch_btn")).click();
		
		}
	
	
		
		
	}

