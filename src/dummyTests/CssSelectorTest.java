package dummyTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorTest extends AbstractWebDriverTest {

	@Test
	public void cssTest() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.thetestroom.com/webapp/");

		// id
		driver.findElement(By.cssSelector("#contact_link")).click();
		// node/tag
		Assert.assertTrue(driver.findElement(By.cssSelector("p")).getText().contains("We are always happy"));
		// class
		driver.findElement(By.cssSelector(".home")).click();
		// attribute expression
		driver.findElement(By.cssSelector("[href='adoption.html']")).click();
		
		driver.close();

	}

}
