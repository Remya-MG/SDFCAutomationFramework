package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.FileUtils;

public class ForgotPasswordPage {

	@FindBy(id = "un")
	public WebElement fpUserName;
	
	@FindBy(id = "continue")
	public WebElement continueButton;
	
	public void enterUName(String username) throws FileNotFoundException, IOException {
		fpUserName.sendKeys(FileUtils.readLoginPropertiesFile("valid.username"));
	}
	
	public void clickContinue() {
		this.continueButton.click();
	}
	
}
