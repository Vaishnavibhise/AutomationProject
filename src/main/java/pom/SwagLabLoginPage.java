package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage {
	
	@FindBy(xpath="//input[@id='user-name']")private WebElement UserId;
	@FindBy(xpath="//input[@id='password']")private WebElement Password;
	@FindBy(xpath="//input[@id='login-button']")private WebElement Login;
	
	public SwagLabLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enterUserId(String user) {
		UserId.sendKeys(user);
	}
	public void enterPassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickOnlogin() {
		Login.click();
	}
}
