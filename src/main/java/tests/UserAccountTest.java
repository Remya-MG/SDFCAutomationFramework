package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.FileUtils;

public class UserAccountTest extends BaseTest{
	
	
	@Test(enabled = false)
	public void verifyAccountCreation_TC10() throws InterruptedException, FileNotFoundException, IOException  {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		AccountPage ap = new AccountPage(driver);
		hp = new HomePage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		lp.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		lp.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		ap.clickAccountsTab();
		Assert.assertTrue(ap.verifyAccountName(), "User account verified");
	}	
		


	@Test
	public void verifyCreateNewView_TC11() throws InterruptedException, FileNotFoundException, IOException  {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		AccountPage ap = new AccountPage(driver);
		hp = new HomePage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		lp.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		lp.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		ap.clickAccountsTab();
		//ap.createNewView();
	}	
	

	@Test
	public void verifyEditView_TC12() throws InterruptedException, FileNotFoundException, IOException  {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		AccountPage ap = new AccountPage(driver);
		hp = new HomePage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		lp.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		lp.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		ap.clickAccountsTab();
		

	}	
	
}
