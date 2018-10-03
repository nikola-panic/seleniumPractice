package dummyTests;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageHeadingTest {
	
	@Test
	public void shouldCheckEachMainPage() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtils util = new WebDriverUtils(driver);
		
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		// home page screen shot
		util.takeScreenShot("homePage");
		
		driver.findElement(By.cssSelector("#adoption_link")).click();
		// adoption page screen shot
		util.takeScreenShot("adoptionPage");
		
		driver.findElement(By.cssSelector("#about_link")).click();
		// about page screen shot
		util.takeScreenShot("aboutPage");
		
		driver.findElement(By.cssSelector("#contact_link")).click();
		// contact page screen shot
		util.takeScreenShot("contactPage");
		
		driver.quit();
	}

}