package dummyTests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAppPageTitleTest {

	WebDriver driver;

	@BeforeEach
	public void TestSetup() {

		// Create an instance of webdriver
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// Go to web page
		driver.navigate().to("http://www.thetestroom.com/webapp");
	}

	@AfterEach
	public void TestShutDown() {

		// Close the driver
		driver.close();
	}

	@Test
	public void ShouldHavePageTitleOfAboutZoo() {

		// Click on the about link
		driver.findElement(By.id("about_link")).click();

		// Check that the about page has the about zoo title
		Assert.assertTrue(driver.getTitle().equals("About Zoo"));
	}

	@Test
	public void ShouldHavePageTitleOfContact() {

		// Click on the about link
		driver.findElement(By.id("contact_link")).click();

		// Check that the about page has the about zoo title
		Assert.assertTrue(driver.getTitle().equals("Contact"));
	}

}
