package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage {
	
	public Home(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\'userLoginBlock\']/a")
	WebElement MyAccount;
	
	@FindBy(xpath = "//*[@id=\'signInBtn\']")
	WebElement Login;
	
	public void clickmyaccount() throws InterruptedException
	{
		Actions act =new Actions (driver);
		
		act.moveToElement(MyAccount).perform();
		
		Thread.sleep(2000);
	}
	
	public void clicklogin()
	{
		Login.click();
	}
	
	
}
