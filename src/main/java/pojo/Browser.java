package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	 
public static WebDriver openChromeBrowser()  {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		//option.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(option);
		
	    driver.navigate().to("");
	    
	    driver.manage().window().maximize();
		return driver;
	}
}
