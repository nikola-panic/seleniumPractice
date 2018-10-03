package dummyTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertWindowTest {

	WebDriver driver;

	@Before
	public void navigate() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.thetestroom.com/webapp");
	}

	@After
	public void testTearDown() {
		driver.close();
	}

	@Test
	public void alertTest() {
		driver.findElement(By.cssSelector("#contact_link")).click();
		driver.findElement(By.cssSelector("#submit_message")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Name"));
		alert.accept();
	}

	@Test
	public void windowTest() {
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.cssSelector("#footer_term")).click();

		for (String currentWindow : driver.getWindowHandles()) {
			driver.switchTo().window(currentWindow);
		}

		System.out.println(driver.getCurrentUrl());

		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
	}

}