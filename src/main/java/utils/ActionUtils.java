package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionUtils {
	
	public static void mousehover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	


	public static void selectDropDownValue(WebDriver driver, WebElement dropDownElement, String value) {
		Select city = new Select(dropDownElement);
		city.selectByValue(value);
	}
}
