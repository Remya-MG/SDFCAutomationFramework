package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{


	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//*[@id=\"Account_Tab\"]/a")
	public WebElement accountsTab;
	 
	@FindBy(xpath = "//*[@id=\"mru005aj000007PfBJ\"]/a")
	public WebElement accountName;

	
	@FindBy(id = "userNav")
	public WebElement userDisplay;
	
	@FindBy(xpath = "//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")
	public WebElement newView;
	
	@FindBy(id = "fname")
    public WebElement viewName;
	
	@FindBy(xpath = "//*[@id=\"devname\"]")
    public WebElement viewUnqName;
	
	@FindBy(xpath = "//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")
    public WebElement saveBtn;
	
	@FindBy(xpath ="//*[@id=\"filter_element\"]/div/span/span[2]/a[1]")
	 public WebElement editView;
	
	@FindBy(id ="fcol1")
	 public WebElement fielddropdown;
	
	@FindBy(id ="fop1")
	 public WebElement operatordropdown;
	 
	@FindBy(id ="fval1")
	 public WebElement valueField;
	
	
	@FindBy(id ="colselector_select_0")
	 public WebElement availableField;
	
	@FindBy(xpath ="//*[@id=\"colselector_select_0_right\"]/img")
	 public WebElement addField;
	
	@FindBy(xpath ="//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]")
	 public WebElement saveEditBtn;
	
	
	 public void clickAccountsTab() throws InterruptedException{
		 this.accountsTab.click();
	 }
	 
	 public void enterViewName(String viewName) {
			this.viewName.sendKeys("TestView1");
		}
		
		public void enterviewUnqName(String viewUnqName) {
			this.viewUnqName.sendKeys("TestViewUnique1");
		}
	 
	 
	 
	 public boolean verifyAccountName() {
		 
		 boolean isAccountNameSame = true;
		 String accName = accountName.getText();
		 String expAccName = userDisplay.getText();
		 System.out.println(accName);
		 System.out.println(expAccName);
		 if (accName.equalsIgnoreCase(expAccName)) {
			 isAccountNameSame = true;
				
			 
		 }
		 else { 
			 isAccountNameSame = false;
		 }
		 return isAccountNameSame;
			 
		 
	 }
	 
	 public void createNewView(String viewName, String viewUnqName) throws InterruptedException {
		 Thread.sleep(2000);
		 this.newView.click(); 
		 this.enterViewName(viewName);
		 this.enterviewUnqName(viewUnqName);
		 saveBtn.click();
	 }
	 
	 
	 public void editView() {
	//	 editView
		 
		 
	 }
	 
}
	
	
