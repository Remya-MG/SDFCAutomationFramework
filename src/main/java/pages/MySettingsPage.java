package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MySettingsPage extends BasePage{


	public MySettingsPage (WebDriver driver) {
		
		super(driver);

	}
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[2]")
	public WebElement mySettings;
	 
	 public MySettingsPage selectMySettingsPage(WebDriver driver) {
		  this.mySettings.click();
		 
		return new MySettingsPage(driver);
		  
	  }
	
	
}
