package dummyTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicXpathTest {

	@Test
	public void xpathTest() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.thetestroom.com/webapp/");

		driver.findElement(By.xpath("//a[contains (@id, 'contact_link')]")).click();
		driver.findElement(By.xpath("//input[contains (@name, 'name_field')]")).sendKeys("test name");

		driver.close();
	}

}
