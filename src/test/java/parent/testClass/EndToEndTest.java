package parent.testClass;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import parent.pageObjects.CartPage;
import parent.pageObjects.HomePage;
import parent.pageObjects.OrderPage;
import parent.pageObjects.ProductCatalog;

public class EndToEndTest 
{
	public static void main(String[] args) 
	   {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.goTo();
		hp.loginApplication("sb@gmail.com", "Shri#12345");
		
		ProductCatalog pc=new ProductCatalog(driver);
		//List<WebElement> products=pc.productList();
		pc.getProductByName("ZARA COAT 3");
		pc.addToCart("ZARA COAT 3");
		pc.getCart();
		
		CartPage cp= new CartPage(driver);
		//List<WebElement>cartList=cp.cartProducts();
		cp.cartProducts();
		Boolean match=cp.getCartProd("ZARA COAT 3");
		Assert.assertTrue(match);
		cp.goToCheckOut();
		
		OrderPage op=new OrderPage(driver);
		op.getCountry("de");
		op.selectCountry("denmark");
		op.placeOrder();
		Assert.assertEquals(op.getSuccessMsg(), "THANKYOU FOR THE ORDER.");
		
		}


}