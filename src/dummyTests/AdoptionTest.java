package dummyTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdoptionTest {

	@Test
	public void shouldSelectFromDropDown() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		driver.findElement(By.cssSelector("#adoption_link")).click();

		Select startDropDown = new Select(driver.findElement(By.cssSelector("#start_select")));
		startDropDown.selectByValue("fmonth");
	}

}
