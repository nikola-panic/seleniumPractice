package dummyTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.PropertyManager;

public class AbstractTestDriver {

	protected WebDriver driver;
	protected PropertyManager property;

	@BeforeEach
	public void testSetUp() {
		property = new PropertyManager();
		property.generateProperty();
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterEach
	public void testShutDown() {
		driver.close();
	}
}
