package dummyTests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationLinksTest {

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
	// Click on the contact link on the left side of the page
	public void ShouldNavigateLinksUsingLocators() {
		driver.findElement(By.id("contact_link")).click();
		Assert.assertTrue(driver.findElement(By.className("subhead")).getText().equals("Contact Form"));
		driver.findElement(By.name("email_field")).sendKeys("This is email field");
		driver.findElement(By.cssSelector("[id=adoption_link]")).click();
		driver.findElement(By.linkText("HOME")).click();
		driver.findElement(By.partialLinkText("ABO")).click();
		Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("animals"));
		driver.findElement(By.xpath("//*[@id='contact_link']")).click();
	}

}
