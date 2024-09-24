package pages;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.FileUtils;



public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Login")
	public WebElement loginButton;
	
	@FindBy(xpath = "//input[@id = 'username']")
	public WebElement userName;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "forgot_password_link")
	public WebElement forgotPassword;
	
	@FindBy(id = "rememberUn")
	public WebElement rememberMe;
	
	@FindBy(id = "hint_back_chooser")
	public WebElement savedUserName;
	
	@FindBy(id = "error")
	public WebElement errorMessage;
	

	
	
	
	public void enterUsername(String username) {
		this.userName.sendKeys(username);
		logger.debug("Username is entered");
	}
	
	public void enterPassword(String passWord) {
		this.password.sendKeys(passWord);
		logger.debug("Password is entered");
	}
	
	
	
	public String getErrorMessage() {
		logger.debug("Error message is fetched");
		return this.errorMessage.getText();
	}
	
	
	
	public String getValueAttribute(WebElement element) {
		return element.getAttribute("value");
	}
	
	public void clickLogin() {
		this.loginButton.click();
		logger.debug("Login button clicked");
	}
	
	
	public void rememberMeCheckBox() {
		this.rememberMe.click();
	}
	
	public void clickForgotPasswordLink() {
		this.forgotPassword.click();
	}
	
	

	
	//This function is written to make sure the application lands on HomePage after clicking the Login from login page.ßß
	public HomePage loginToApp(WebDriver driver) throws FileNotFoundException, IOException {
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		logger.debug("Navigated to Login Page");
		this.enterUsername(FileUtils.readLoginPropertiesFile("valid.username"));
		this.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		this.clickLogin();
		
		return new HomePage(driver);
	}
	
	public HomePage loginToApp(WebDriver driver, String username, String passWord) {
		this.enterUsername(username);
		this.enterPassword(passWord);
		this.clickLogin();
		return new HomePage(driver);
	}
	
	

}
