package tests;

import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.FileUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.SFDCListeners;

@Listeners(SFDCListeners.class)

public class LoginTest extends BaseTest{
	
	@Test
	public void loginErrorMessageTC01() throws FileNotFoundException, IOException {
		
		final String assertMessage = "The actual and expected usernames should be same";
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		String expectedUserName = FileUtils.readLoginPropertiesFile("valid.username");
		lp.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		
		String actualUserName = lp.getValueAttribute(lp.userName);
		Assert.assertEquals(expectedUserName, actualUserName,assertMessage );
		lp.password.clear();
		String actualPassword = lp.getValueAttribute(lp.password);
		Assert.assertEquals("", actualPassword, "The actual and expected passwords should be same");
		
		lp.clickLogin();
		CommonUtils.captureScreenshot(driver);
		Assert.assertEquals(lp.getErrorMessage(),FileUtils.readLoginPropertiesFile("error.text"),"Error message is displayed");
		logger.info("Execution completed: loginErrorMessageTC01");
		
	}
	
	@Test
	public void loginToSalesForceTC02() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		String expectedUserName = FileUtils.readLoginPropertiesFile("valid.username");
		lp.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		
		String actualUserName = lp.getValueAttribute(lp.userName);
		Assert.assertEquals(expectedUserName, actualUserName, "The actual and expected usernames should be same");
		
		String actualPassword = lp.getValueAttribute(lp.password);
		Assert.assertEquals("", actualPassword, "The actual and expected passwords should be same");
		lp.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		
		Assert.assertEquals(driver.getTitle(),FileUtils.readLoginPropertiesFile("homepage.title"));
		
		
	}
	
	
	@Test(enabled = false)
	public void rememberMeTC03() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		String expectedUserName = FileUtils.readLoginPropertiesFile("valid.username");
		
		HomePage hPage = lp.loginToApp(driver, expectedUserName,  FileUtils.readLoginPropertiesFile("valid.password"));
		Thread.sleep(5000);
		Assert.assertTrue(hPage.isHomePage(), "User should be in home page");
		hp.clickUserMenu();
		hp.clickLogOut();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),FileUtils.readLoginPropertiesFile("loginpage.title"));
		Thread.sleep(5000);
		String savedUserName1 = lp.getValueAttribute(lp.savedUserName);
		System.out.println(savedUserName1);
		//Assert.assertEquals(actualUserName,savedUserName);
		
	}
	
	@Test(enabled = false)
	public void forgotPasswordTC04A() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = new HomePage(driver);
		fp = new ForgotPasswordPage();
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		lp.clickForgotPasswordLink();
		Assert.assertEquals(driver.getTitle(),FileUtils.readLoginPropertiesFile("forgotpasswordpage.title"));
		fp.enterUName(FileUtils.readLoginPropertiesFile("valid.username"));
		fp.clickContinue();
		

		
	}
	
	@Test(enabled = false) 
	public void forgotPasswordTC04B() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = new HomePage(driver);
		fp = new ForgotPasswordPage();
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		lp.enterUsername(FileUtils.readLoginPropertiesFile("wrong.username"));
		lp.enterPassword(FileUtils.readLoginPropertiesFile("wrong.password"));
		lp.clickLogin();
		
		
		Assert.assertEquals(lp.getErrorMessage(),FileUtils.readLoginPropertiesFile("error.text.wrong.crendentials"),"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		
	}
	
	
}
