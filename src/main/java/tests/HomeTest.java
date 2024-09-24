package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;
import pages.MySettingsPage;
import utils.FileUtils;

public class HomeTest extends BaseTest{
	
	/*@BeforeMethod
	public void login() throws FileNotFoundException, IOException {
		//WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		
	}*/
	
	
	@Test(enabled = false)

	public void userMenuTC05() throws FileNotFoundException, IOException, InterruptedException {

	driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
	HomePage hPage = lp.loginToApp(driver,FileUtils.readLoginPropertiesFile("valid.username") , FileUtils.readLoginPropertiesFile("valid.password"));
	Thread.sleep(5000);
	Assert.assertEquals(driver.getTitle(),FileUtils.readLoginPropertiesFile("homepage.title"));
	Assert.assertTrue(hPage.isHomePage(), "User should be in home page");
	
	Assert.assertTrue(hp.isUserNameVisible());
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Assert.assertTrue(hp.verifyUserMenuOptions(),"User Menu options should be verified");
	hp.clickLogOut();
	
	
	}
	
	@Test(enabled = false)
	public void verifyMyProfile_TC06() throws FileNotFoundException, IOException, InterruptedException {
		hp = new HomePage(driver);
		hp.clickUserMenu();
		Assert.assertTrue(hp.verifyUserMenuOptions(), "User Menu options should be verified");
		MyProfilePage profilePage = hp.selectMyProfilePage(driver);
		profilePage.clickEditProfile(driver);
	    Assert.assertTrue(profilePage.verifyContactIframeAvailability(driver), "");
	    Assert.assertTrue(profilePage.verifyAboutTab(driver), "");
	    
	    Assert.assertTrue(profilePage.verifyLastNameChange(),"");
	    Assert.assertTrue(profilePage.verifyCreatePost(driver, "Hello Team"));
	    Assert.assertTrue(profilePage.verifyFileUpload(driver));
	    profilePage.clickOnAddPhoto(driver);
	    Assert.assertTrue(profilePage.verifyAddPhoto(driver)); 
	}

	@Test(enabled = false)
	public void verifyMySettings_TC07() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = new HomePage(driver);
		sp = new MySettingsPage(driver);
		hp.clickUserMenu();
		Assert.assertTrue(hp.verifyUserMenuOptions(), "User Menu options should be verified");
		MySettingsPage settingspage = sp.selectMySettingsPage(driver);
	   
	
	}
	
	@Test(enabled = false)

	
	public void verifyDevConsole_TC08() throws InterruptedException, FileNotFoundException, IOException  {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = new HomePage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		lp.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		lp.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		Thread.sleep(5000);
		hp.clickUserMenu();
	    hp.clickDevConsole();
		Assert.assertTrue(hp.isHomePage(), "User should be in home page");
		
	}
	
	

	@Test(enabled = false)
	
	public void verifyLogOut_TC09() throws InterruptedException, FileNotFoundException, IOException  {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = new HomePage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		lp.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		lp.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		Thread.sleep(5000);
		hp.clickUserMenu();
	    hp.clickLogOut();
	    Thread.sleep(5000);
	    Assert.assertEquals(driver.getTitle(),FileUtils.readLoginPropertiesFile("loginpage.title"));
		
	}
}	
	
