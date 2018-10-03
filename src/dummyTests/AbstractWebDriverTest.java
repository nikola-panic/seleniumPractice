package dummyTests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePage;

public class AbstractWebDriverTest {
	
	protected WebDriver driver;
	protected HomePage onHomePage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		onHomePage = new HomePage(driver);
		System.out.println("before in abstract");
		
	}
	
	@After
	public void shutDown() {
		driver.close();
		System.out.println("after in abstract");
	}

}
