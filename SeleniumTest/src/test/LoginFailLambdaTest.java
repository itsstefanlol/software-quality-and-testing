package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginFailLambdaTest {
	
	WebDriver driver;
	
	//Use case 1: Log in
	@Test
	public void LoginFail() throws InterruptedException { 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Visit website
		driver.get("https://www.lambdatest.com/");
		Thread.sleep(1000);
		
		//Find Login button and input the credentials.
		driver.findElement(By.linkText("Login")).click();
		
		//Input dummy email and password		
		driver.findElement(By.id("email")).sendKeys("stefanpopov2409@gmail.com");
		driver.findElement(By.id("password")).sendKeys("testPassword");
		Thread.sleep(1000);
		
		//Click Login Button
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(2000);
		
		//Get the title and compare it to the expected value
		String ActualValue=driver.getTitle(); 
		String ExpectedValue="Welcome - LambdaTest";		
		
		//If these are not equal, it means that the user faced some issues during logging in.
		assertNotEquals(ActualValue, ExpectedValue);
		
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chromedriver", "C:\\Users\\USER\\OneDrive\\Desktop\\Stefan\\Fax\\III godina\\6. Leten semestar\\SKT\\proj\\Installers\\driver\\chromedriver.exe");
		LoginFailLambdaTest object = new LoginFailLambdaTest();
		object.LoginFail();

	}
	
}
