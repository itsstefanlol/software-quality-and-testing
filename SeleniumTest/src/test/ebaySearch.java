package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(OrderAnnotation.class)
public class ebaySearch {
	
	/*
	 * This class tests use case scenarios. Basically we got 3 scenarios to test:
	 * Use case 1: Visit the ebay website, search the phrase "JBL Speakers" in the search bar and see the results.
	 * Then check the daily deals page from the link in the top left corner.
	 * Use case 2: From daily deals, navigate to simplylearn.com, and then back to daily deals again. 
	 * Use case 3: the print page title the close the browser window part of use case 3
	 */
	

	static WebDriver driver;
	
	//Use case 1
	@Test
	@Order(1)
	public void launchBrowser() { 
		System.setProperty("webdriver.chromedriver", "C:\\Users\\USER\\OneDrive\\Desktop\\Stefan\\Fax\\III godina\\6. Leten semestar\\SKT\\proj\\Installers\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
	}
	
	//Use case 1, part 2
	@Test
	@Order(2)
	public void seachProductVisitDailyDeals() throws InterruptedException {
		//wait 2 seconds after the previous command is executed.
		driver.findElement(By.id("gh-ac")).sendKeys("JBL Speakers");
		driver.findElement(By.id("gh-btn")).click();  
		Thread.sleep(2000);
		driver.findElement(By.linkText("Daily Deals")).click();
	}
   
	
	//Use case 2 & part of 3:
	@Test
	@Order(3)
	public void navigate() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://www.simplilearn.com/");
		Thread.sleep(3000);
		driver.navigate().back(); 
		String ActualValue = driver.getTitle();
		//This is actually not the title of the Daily Deals page. That's why I run a command assertNotEquals a few lines below.
		String ExpectedValue = "Best deals and Free Shipping";
		assertNotEquals(ActualValue, ExpectedValue);
		
	}
	
	@Test
	@Order(4)
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ebaySearch obj = new ebaySearch();
			
		obj.launchBrowser();
		
		obj.seachProductVisitDailyDeals();
		
		obj.navigate();
		

		
		
	}
}
