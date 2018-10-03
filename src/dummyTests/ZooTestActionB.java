package dummyTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ZooTestActionB extends AbstractWebDriverTest {

	@Test
	public void testActionBuilderClass() {
		driver.navigate().to("http://www.thetestroom.com/webapp/");

		driver.findElement(By.cssSelector("#adoption_link")).click();

		Actions dropDown = new Actions(driver).click(driver.findElement(By.cssSelector("#start_select")))
				.click(driver.findElement(By.cssSelector("option:nth-child(3)")));

		dropDown.build().perform();

		driver.findElement(By.cssSelector("#contact_link")).click();

		Actions slider = new Actions(driver).dragAndDropBy(driver.findElement(By.cssSelector("#slider-1")), 120, 0);

		slider.build().perform();
	}

}