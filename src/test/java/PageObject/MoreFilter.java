package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import utilities.ExcelUtils;

public class MoreFilter extends BaseClass{

	public MoreFilter(WebDriver driver) {
		super();
	}
	
	@Test
	public void clickmorefilter() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[1]/div/div[2]/div[7]/span")).click();
		
		Thread.sleep(2000);
		
		WebElement Price =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p"));
		
		Actions moveact =new Actions (driver);
		
		WebElement scroller =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/div/div/div[2]"));
		
		moveact.dragAndDropBy(scroller, 0, 250).perform();
		
		WebElement amount =driver.findElement(By.xpath("//*[@id=\'Flight-APP\']/section/section[1]/div/div[2]/div/div/div[3]/div/p/span[2]"));
		
		String amountvalue=amount.getText();
		
		System.out.println(amountvalue);
		
		
		//------------------------------------Selecting the Airlines---------------------------------------------------
		
		Thread.sleep(2000);
		
		moveact.moveToElement(driver.findElement(By.xpath("//span[text()='Vistara Business']"))).click().perform();
		
		//-----------------------------------Click Filter button-------------------------------------------------------
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Apply Filters']")).click();
		
		

		
		
	}
	
}
