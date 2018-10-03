package dummyTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactMessageTest {

	WebDriver driver;

	@BeforeEach
	public void TestSetUp() {

		// Create an instance of webdriver
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		// Go to web page
		driver.navigate().to("http://www.thetestroom.com/webapp");
	}

	@AfterEach
	public void testTearDown() {
		driver.close();
	}

	@Test
	public void shouldSendValidMessage() {

		Click(By.id("contact_link"));
		assertTrue(driver.getTitle().equals("Contact"));

		type(By.name("name_field"), "test name");
		type(By.name("address_field"), "test address");
		type(By.name("postcode_field"), "test field");
		type(By.name("email_field"), "test email");

		assertFalse(!(driver.findElement(By.name("name_field")).getText().isEmpty()));

		Click(By.id("submit_message"));
		assertEquals(driver.getTitle(), "Contact Confirmation");
	}

	public void type(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void Click(By by) {
		driver.findElement(by).click();
	}
}
