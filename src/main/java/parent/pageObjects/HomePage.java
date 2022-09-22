package parent.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.utilities.UtilityClass;

public class HomePage extends UtilityClass 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);  // used to send driver to parent class(Utitlity class).
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPasword;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPasword.sendKeys(password);
		submit.click();
		//return ProductCatalog(driver);
	}
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
