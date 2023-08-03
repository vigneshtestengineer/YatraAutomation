package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass()
	@Parameters("browser")
	
	public void setup(String browser) throws InterruptedException, IOException {
		
//		FileInputStream fis =new FileInputStream("src/test/resources/config.properties");
//		Properties pro =new Properties();
//		pro.load(fis);
		
		Locale usLocale =new Locale("en", "US");
		rb=ResourceBundle.getBundle("config" ,usLocale);  // Load config.properties file 
		
		
		
		logger =LogManager.getLogger(this.getClass());  // Create the Log file
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.acceptInsecureCerts();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excluseSwitches", new String[] {"enable-automation"});
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.merge(dc);
		
		
		if(browser.equals("chrome")) {
			
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//			
//			WebDriver driver = new ChromeDriver(options);
			
		driver =new ChromeDriver(options);
			
		}else {
			driver =new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();

		Thread.sleep(1000);
		
     	driver.get(rb.getString("appurl"));
		
		driver.manage().window().maximize();
		
		
		
	}
	
	@AfterClass()
	public void browsershutdown() throws EmailException{
		SendEmail mailing =new SendEmail();
		mailing.mailsending();
		driver.quit();
	}
	
	
	public String captureScreen(String tname) {
		
		String timeStamp =new SimpleDateFormat("yyyyMmddhhmmss").format(new Date());
		TakesScreenshot screenshot =(TakesScreenshot) driver;
		File source =screenshot.getScreenshotAs(OutputType.FILE);
		String designation =System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(designation));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return designation;
		
	}

}
