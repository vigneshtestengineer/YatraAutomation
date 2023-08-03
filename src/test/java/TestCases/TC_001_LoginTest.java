package TestCases;

import TestBase.BaseClass;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import PageObject.Home;
import PageObject.LoginPage;

public class TC_001_LoginTest extends BaseClass {
	@Test
	void login_test(){
		logger.debug("*** Log Info ***");
		
		logger.info("______________Starting TC_001_LoginTest___________________ ");
		try {
		
		
		Home hp =new Home(driver);
		
		hp.clickmyaccount();
		logger.info("Account menu is hovered");
		Thread.sleep(500);		
		hp.clicklogin();
		logger.info("Login is selected sucessfully");
		
		Thread.sleep(500);
		
		LoginPage LP =new LoginPage(driver);
		Thread.sleep(500);
		
		// Click using mouse
		
		Actions act =new Actions (driver);
		
		act.click(driver.findElement(By.xpath("//*[@id=\'login-input\']"))).build().perform();
		
	    act.sendKeys(rb.getString("email")).build().perform();
	    
	    logger.info("Email entered sucessfully");
	    
	    act.click(driver.findElement(By.xpath("//*[@id=\'login-continue-btn\']"))).build().perform();
	    
	    Thread.sleep(1000);
	    
	    act.click(driver.findElement(By.xpath("//*[@id=\'login-password\']"))).build().perform();
	    
	    act.sendKeys(rb.getString("pwd")).build().perform();
	    
	    logger.info("Password page is opened sucessfully");
	    
	    logger.info("Password entered sucessfully");
	    
	    Thread.sleep(2000);
	    
	    act.click(driver.findElement(By.xpath("//*[@id=\'login-submit-btn\']"))).build().perform();
	    
	    Thread.sleep(1000);
	    
	    logger.info("Login button clicked sucessfully");
	    
	    
//		WebElement welcome = driver.findElement(By.xpath("//*[@id=\'login-form-container\']/section/p[1]"));
//		System.out.println(welcome);
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\'login-form-container\']/div/section")));
//		
//		System.out.println(driver.findElement(By.xpath("//*[@id=\'login-title\']")));
		
		
//		LP.enteremail("vignesh");
		
//		LP.continuebtn();
//		
//		Thread.sleep(2000);
//		
//		LP.password("90807@Kv");
//		
//		LP.loginbtn();
//		Thread.sleep(5000);
		
		System.out.println(driver.getCurrentUrl());
		
		
		
	}catch(Exception e) {
	
			Assert.fail("Failed");
	}
	}

}
