package dummyTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ZooTest {

	@Test
	public void testHeadLessBrowser() {
		WebDriver driver = new HtmlUnitDriver();
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		driver.findElement(By.cssSelector("#about_link")).click();
		Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("We love our animals"));
		driver.quit();
	}

}