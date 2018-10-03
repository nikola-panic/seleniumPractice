package dummyTests;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectionsTest {

	WebDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.thetestroom.com/webapp");
	}

	@AfterEach
	public void shutDown() {
		driver.close();
	}

	@Test
	public void collectionTest() {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			if (link.getText().equals("CONTACT")) {
				link.click();
				break;
			}
		}

		List<WebElement> fields = driver.findElements(By.tagName("input"));

		for (WebElement field : fields) {
			if (field.getAttribute("name").contains("name")) {
				field.sendKeys("name_test");
			}
			if (field.getAttribute("name").contains("address")) {
				field.sendKeys("address_test");
			}
			if (field.getAttribute("name").contains("postcode")) {
				field.sendKeys("postcode_test");
			}
			if (field.getAttribute("name").contains("email")) {
				field.sendKeys("email_test");
			}
		}

	}

}
