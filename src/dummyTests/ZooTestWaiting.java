package dummyTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZooTestWaiting extends AbstractWebDriverTest {

	@Test
	public void shouldBeAbleToSubmitForm() {
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		// wait until paragraph is visible
		waitUntilElementIsVisible(By.tagName("p"), 5000);
		driver.findElement(By.cssSelector("#contact_link")).click();
		// wait for 5 seconds
		wait(5);
		driver.findElement(By.name("name_field")).sendKeys("test name");
		driver.findElement(By.name("address_field")).sendKeys("test address");
		driver.findElement(By.name("postcode_field")).sendKeys("18000");
		driver.findElement(By.name("email_field")).sendKeys("test@mail.com");
		driver.findElement(By.cssSelector("#submit_message")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("contact_confirm"));
	}

	// wait for a set amount of time
	// should be able to set the wanted time
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// wait for required time only
	public WebElement waitUntilElementIsVisible(By locator, int maxSeconds) {
		return (new WebDriverWait(driver, maxSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}