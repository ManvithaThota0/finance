package com.pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login {

	WebDriver driver;
	
	
	@BeforeMethod
	public void SetupDriver() {
		
		String Browser="Chrome";
		
		if(Browser.equals("Chrome")){
			driver=new ChromeDriver();
		}else if(Browser.equals("Firefox")){
			driver=new FirefoxDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(Browser.equals("Safari")) {
			driver=new SafariDriver();
		}
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.citi.com/");
	String Title=driver.getTitle();
	System.out.println("Title of Citibank = " +Title);
	
	}
	
	@AfterMethod
	public void TearDown() {
		
	   driver.quit();
	}
	
	
	@Test(priority=1, enabled=false)
	public void Login() {
		
		driver.findElement(By.xpath("//Div[contains(@class,'cds-form-field-input')]//input[@formcontrolname='username']")).sendKeys("manvitha.thota@gmail.com");
		driver.findElement(By.xpath("//Div[contains(@class,'cds-form-field-input')]//input[@formcontrolname='password']")).sendKeys("Devops@87.");
		driver.findElement(By.xpath("//Div[contains(@class,'form-group ')]//button[@cdsbutton='primary']")).click();
		
		String ExpectedMsg="Your information doesn't match our records. Try again, or reset your password.";
		String Actualmsg=driver.findElement(By.xpath("//div[contains(@class,'cds-form-field-infix')]//span[1]")).getText();
		Assert.assertTrue(Actualmsg.contains(ExpectedMsg),"Your information doesn't match our records. Try again, or reset your password.");
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Actualmsg)));
		//fluent wait
		//Wait<WebDriver> fluentwait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
	}
	
	@Test(priority=2, enabled=false)
    public void InvalidCredentials() throws InterruptedException {
		
		driver.findElement(By.xpath("//Div[contains(@class,'cds-form-field-input')]//input[@formcontrolname='username']")).sendKeys("manvitha.thot@gmail.com");
		driver.findElement(By.xpath("//Div[contains(@class,'cds-form-field-input')]//input[@formcontrolname='password']")).sendKeys("Devops@87.");
		driver.findElement(By.xpath("//Div[contains(@class,'form-group ')]//button[@cdsbutton='primary']")).click();
		
		String ExpectedMsg="Your information doesn't match our records. Try again, or reset your password.";
		String Actualmsg=driver.findElement(By.xpath("//div[contains(@class,'cds-form-field-infix')]//span[1]")).getText();
		Assert.assertTrue(Actualmsg.contains(ExpectedMsg),"Your information doesn't match our records. Try again, or reset your password.");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=3, enabled=true)
	public void Dropdown() throws InterruptedException {
		
		WebElement Creditcard=driver.findElement(By.xpath("//li[@role='listitem']//a[text()='Credit Cards']"));
		Thread.sleep(3000);
     	WebElement ViewAllCreditCards=driver.findElement(By.xpath("//*[text()='View All Credit Cards']"));
     	Actions action=new Actions(driver);
		action.moveToElement(Creditcard).moveToElement(ViewAllCreditCards).click().build().perform();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='mppHeaderContent?.pageHeader']")));
		
		String Actual=driver.findElement(By.xpath("//h1[@id='mppHeaderContent?.pageHeader']")).getText();
        String Expected="View and Compare All Credit Cards";
        Assert.assertEquals(Actual, Expected);
    
	}

// List<WebElement> CardOptions= driver.findElements(By.xpath("//li[@role='listitem']//a[text()='Credit Cards']"));
//	for(WebElement Options: CardOptions) {
//		if(Options.getText().equals("View and Compare All Credit Cards")){
//			Options.click();
//			break;
//		}
//	}
//	Thread.sleep(5000);
	
	
	@Test(priority=4, enabled=false)
	public void CreditCardsDropdown(){
		
		 WebElement Ele=driver.findElement(By.xpath("//li[contains(@class,'mainListItems')]//a[1]"));
		   
		   Select Sel=new Select(Ele);
		   Sel.selectByIndex(0);
		   
		   WebElement Ele2=driver.findElement(By.linkText("View All Credit Cards"));
		   
		   WebDriverWait Wt=new WebDriverWait(driver, Duration.ofSeconds(10));
		   Wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View All Credit Cards")));
		   
		   try{
			   Ele2.click();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   System.out.println("Dropdown successfully clicked");	
		   
	}	

}
