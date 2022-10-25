package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.ExtentReport;
import utility.Parametrization;

@Listeners(utility.Listeners.class)
public class SwagLabLoginPageTest {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports = ExtentReport.getReports();
	}
	
	@BeforeMethod
	public void launchApllication() {
		 Browser.openChromeBrowser();
	}
	@Test
	public void SwagLabTest()throws EncryptedDocumentException,IOException {
		test=reports.createTest("SwagLabTest");
		
		SwagLabLoginPage SwagLabLoginPage=new SwagLabLoginPage(driver);
		SwagLabLoginPage.enterUserId(Parametrization.getExcelData(0, 0,null));
		SwagLabLoginPage.enterPassword(Parametrization.getExcelData(0, 0,null));
		SwagLabLoginPage.clickOnlogin();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		//Assert.assertsEquals(driver.getCurrentUrl(),expectedUrl);
	}
	@AfterMethod
	public void  captureResults(ITestResult result){
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if (result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
		
		@AfterTest
		public void flushResults() {
			reports.flush();
		}
}
