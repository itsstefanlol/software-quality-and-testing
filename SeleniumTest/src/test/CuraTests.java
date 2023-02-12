package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CuraTests {

	WebDriver driver;
	String APP_URI="https://katalon-demo-cura.herokuapp.com/";
	String MAKE_APPOINTMENT_BUTTON_ID="btn-make-appointment";
	String EXPECTED_VALUE_TITLE_AFTER_CLICK_APPOINTMENT_BUTTON="CURA Healthcare Service";
	String INPUT_USERNAME_LOGIN_ID="txt-username";
	String USERNAME_VALUE="John Doe";
	String INPUT_PASSWORD_LOGIN_ID="txt-password";
	String PASSWORD_VALUE="ThisIsNotAPassword";
	String LOGIN_BUTTON_ID="btn-login";
	String EXPECTED_URI_VALUE_AFTER_LOGIN="https://katalon-demo-cura.herokuapp.com/#appointment";
	String SELECT_FACILITY_ID="combo_facility";
	String SELECT_OPTION_VALUE="Hongkong CURA Healthcare Center";
	String READMISSON_CHECKBOX_ID="chk_hospotal_readmission";
	String HEALTHCARE_PROGRAM_RADIOBOX_ID="radio_program_medicaid";
	String VISIT_DATE_INPUT_ID="txt_visit_date";
	String VISIT_DATE_VALUE="19/12/2023";
	String COMMENT_INPUT_ID="txt_comment";
	String COMMENT_VALUE="Example comment";
	String BOOK_APPOINTMENT_BUTTON_ID="btn-book-appointment";
	
	@Test
	public void MakeAppointment() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(APP_URI);
		Thread.sleep(1000);	
		driver.findElement(By.id(MAKE_APPOINTMENT_BUTTON_ID)).click();
		Thread.sleep(1000);
		
		//Check if the clicking sent the user to the login page by checking if the page title is the expected value.
		String ExpectedValueTitle=EXPECTED_VALUE_TITLE_AFTER_CLICK_APPOINTMENT_BUTTON;
		String ActualValueTitle=driver.getTitle();
		assertEquals(ExpectedValueTitle, ActualValueTitle);
		
		driver.findElement(By.id(INPUT_USERNAME_LOGIN_ID)).sendKeys(USERNAME_VALUE);
		Thread.sleep(500);
		
		driver.findElement(By.id(INPUT_PASSWORD_LOGIN_ID)).sendKeys(PASSWORD_VALUE);
		Thread.sleep(500);
		
		driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
		Thread.sleep(1000);

		//https://katalon-demo-cura.herokuapp.com/#appointment
		String ExpectedPageTitle=EXPECTED_URI_VALUE_AFTER_LOGIN;
		String ActualPageTitle=driver.getCurrentUrl();
		assertEquals(ExpectedPageTitle,ActualPageTitle);
		Thread.sleep(1000);
		
		WebElement selectElement = driver.findElement(By.id(SELECT_FACILITY_ID));
        Select select = new Select(selectElement);
        List<WebElement> optionList = select.getOptions();
        select.selectByVisibleText(SELECT_OPTION_VALUE);
		Thread.sleep(500);
        
		driver.findElement(By.id(READMISSON_CHECKBOX_ID)).click();
		Thread.sleep(500);
        
		driver.findElement(By.id(HEALTHCARE_PROGRAM_RADIOBOX_ID)).click();
		Thread.sleep(500);

		driver.findElement(By.id(VISIT_DATE_INPUT_ID)).sendKeys(VISIT_DATE_VALUE);
		Thread.sleep(500);

		driver.findElement(By.id(COMMENT_INPUT_ID)).sendKeys(COMMENT_VALUE);
		Thread.sleep(500);
		
		driver.findElement(By.id(BOOK_APPOINTMENT_BUTTON_ID)).click();
		Thread.sleep(500);
		
		assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Appointment Confirmation"));
		
		String ExpectedCommentValue=COMMENT_VALUE;
		String ActualCommentValue=driver.findElement(By.id("comment")).getText();
		assertEquals(ExpectedCommentValue, ActualCommentValue);
		Thread.sleep(1000);
		
		

        
	}
	
	
	
	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver", "C:\\Users\\USER\\OneDrive\\Desktop\\Stefan\\Fax\\III godina\\6. Leten semestar\\SKT\\proj\\Installers\\driver\\chromedriver.exe");
		CuraTests object = new CuraTests();
		object.MakeAppointment();
		Thread.sleep(1000);
		/*
		 * object.AccessWebsite(); Thread.sleep(1000);
		 * object.ClickMakeAppointmentButton(); Thread.sleep(1000); object.Login();
		 */

	}

}
