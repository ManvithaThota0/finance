package automation_test;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    
	WebDriver driver;
	@BeforeTest
	public void SetupDriver(){
	
	//1.Navigate to https://www.saucedemo.com/	
    driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.saucedemo.com/");
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void Login(){

	WebElement Uname=driver.findElement(By.xpath("//input[@id='user-name']"));
	WebElement Pwd=driver.findElement(By.xpath("//input[@name='password']"));
	WebElement Login=driver.findElement(By.xpath("//input[@id='login-button']"));
	WebElement Errormsg=driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));
	WebElement Header=driver.findElement(By.xpath("//div[text()='Swag Labs']"));
	
	//2. a. Try to login with a locked-out user [locked_out_user/ secret_sauce].
	Uname.sendKeys("locked_out_user");
	Pwd.sendKeys("secret_sauce");
	Login.click();
	//b. Validate the error message on the screen.
	String Actual = Errormsg.getText();
	String Expected = "Epic sadface: Sorry, this user has been locked out.";
	Assert.assertEquals(Actual, Expected);
	
	
	//3. a. Login with a valid username and password [standard_user/ secret_sauce].
	Uname.sendKeys("standard_user");
	Pwd.sendKeys("secret_sauce");
	Login.click();
	//b. Validate login is successful.
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Swag Labs']")));
	String Actual1=Header.getText();
	String Expected1="Swag Labs";
	Assert.assertEquals(Actual1, Expected1);
	
	
	//4. Assert that the product- “Dummy Product” is not present in the product list.
	List<WebElement> ProductLinks=driver.findElements(By.tagName("a"));
	
	for(WebElement prods: ProductLinks) {
		if(prods.getText().contains("Dummy Product")){
			System.out.println("Dummy Product is present in the product list");
		}else {
			System.out.println("Dummy product is not present in the product list");
		}
		
	//5. a. Assert that the product “Sauce Labs Bolt T-Shirt" is present in the product list.
		WebElement Saucelabs_BoltT_Shirt=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
	    if(prods.getText().contains("Sauce Labs Bolt T-Shirt")) {
	    	System.out.println("Sauce Labs Bolt T-Shirt is present in the product list");
		}else {
			System.out.println("Sauce Labs Bolt T-Shirt is not present in the product list");
		}
	 
	//b. If the product is found, grab the price of the product and print it in the console.
	if(Saucelabs_BoltT_Shirt.isDisplayed()) {
		WebElement Bolt_TShirt=driver.findElement(By.xpath("//div[@class='inventory_item'][3]//div[@class='inventory_item_price']"));
		System.out.println(Bolt_TShirt.getText());	
	}
	
	}
	
	//6. a. Add this product and any other product to the cart and navigate to the cart.
	WebElement AddBolt_TshirttoCart= driver.findElement(By.xpath("//div[@class='inventory_item'][3]//button[text()='Add to cart']"));
	AddBolt_TshirttoCart.click();
	
	WebElement Fleece_Jacket=driver.findElement(By.xpath("//div[@class='inventory_item'][4]//div[@class='inventory_item_price']"));
	System.out.println(Fleece_Jacket.getText());
	
	WebElement AddFleeceJacket_toCart=driver.findElement(By.xpath("//div[@class='inventory_item'][4]//button[text()='Add to cart']"));
	AddFleeceJacket_toCart.click();
	
	//b. Validate that the correct price for these products is displayed on the cart.
	WebElement Shopping_Cart= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	Shopping_Cart.click();
	
	WebElement PriceofItem1= driver.findElement(By.xpath("//div[@class='item_pricebar']//div[text()='15.99']"));
	WebElement PriceofItem2= driver.findElement(By.xpath("//div[@class='item_pricebar']//div[text()='49.99']"));
	
	if(PriceofItem1.isDisplayed()) {
		System.out.println("PriceofItem1 is correctly displayed in the cart");
	}else {
		System.out.println("PriceofItem1 is not correct");
	}
	
	if(PriceofItem2.isDisplayed()) {
		System.out.println("PriceofItem2 is correctly displayed in the cart");
	}else {
		System.out.println("PriceofItem2 is not correct");
	}
	
		
}	
	
	
	
	
}

