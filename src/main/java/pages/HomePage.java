package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.FileUtils;
import utils.WaitUtils;

public class HomePage  extends BasePage{

public HomePage (WebDriver driver) {
		
		super(driver);
	}


@FindBy(id = "userNavLabel") 
public WebElement userLabel;



 @FindBy(xpath = "//a[@class = \"menuButtonMenuLink\" and @title = \"Logout\"]")
 public WebElement logOut;
 
 
 @FindBy(xpath = "//h2[text() = 'Community']")
 public WebElement communityPanel;
 
 @FindBy(id = "userNavButton")
 public WebElement userMenu;
 
 @FindBy(xpath = "//*[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;
	
 @FindBy(xpath = "//*[@id='userNav-menuItems']/a[1]")
	public WebElement myProfile;
 
 
 @FindBy(xpath = "//div[@id = 'userNav-menuItems']/a[@title = 'Developer Console (New Window)']")
  public WebElement devConsole;
 
 

 
 public boolean isHomePage() {
	 return this.communityPanel.isDisplayed();
 }
 
 public boolean isUserNameVisible() {
	 return this.userLabel.isDisplayed();
 }
 
 public void clickLogOut() {
	 this.logOut.click();
 }

 public void clickUserMenu() throws InterruptedException{
	 Thread.sleep(5000);
	 this.userMenu.click();
 }
 
 public void clickDevConsole() {
	 this.devConsole.click();
 }
 
 
 
 public LoginPage logoutOfApp(WebDriver driver, WebElement logOut, WebElement userLabel) throws InterruptedException {
		this.clickUserMenu();
		this.clickLogOut();		
		return new LoginPage(driver);
	}
 
 public boolean verifyUserMenuOptions() throws FileNotFoundException, IOException {
	 
	 boolean isUserMenuOptionsVerified = true;
		String[] expectedUserMenuOptions = FileUtils.readHomePropertiesFile("usermenu.options").split(",");
		for (int i = 0; i < expectedUserMenuOptions.length; i++) {
			if (expectedUserMenuOptions[i].equals(userMenuOptions.get(i).getText())) {
				System.out.println(
						"Expected: " + expectedUserMenuOptions[i] + " Actual: " + userMenuOptions.get(i).getText());
			} else {
				isUserMenuOptionsVerified = false;
			}
		}
		return isUserMenuOptionsVerified;
	 
 }
 
 
  public MyProfilePage selectMyProfilePage(WebDriver driver) {
	  this.myProfile.click();
	 
	return new MyProfilePage(driver);
	  
  }
  
  
  public void DevConsoleWindowHandling(WebDriver driver) {
	  
	  Set<String> windows = driver.getWindowHandles();
		 String parentWindow = driver.getWindowHandle();
		 String devConsoleWindow = "";
		 for(String s : windows) {
			 devConsoleWindow = s;
		 }
		 driver.switchTo().window(devConsoleWindow);
		 driver.close();
		 driver.switchTo().window(parentWindow);
		 
	  
  }
  
  
 
}
