package dummyTests;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class ZooTestHamcrest extends AbstractWebDriverTest {
	
	@Test
	public void testHamcrest() {
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		String pageText = driver.findElement(By.cssSelector(".content")).findElement(By.tagName("h1")).getText();
		assertTrue("Page Title did not contain WELCOME", pageText.contains("WELCOME"));
		assertThat(pageText, is("WELCOME TO THE ZOO ADOPTION CENTER"));
		
		driver.findElement(By.cssSelector("#adoption_link")).click();
		pageText = driver.findElement(By.cssSelector(".content")).findElement(By.tagName("h1")).getText();
		assertEquals("ADOPTION OPTIONS", pageText);
		assertThat(pageText, equalTo("ADOPTION OPTIONS"));
		
		driver.findElement(By.cssSelector("#about_link")).click();
		assertFalse(driver.getCurrentUrl().contains("adoption"));
		assertThat(driver.getCurrentUrl(), instanceOf(String.class));
	}

}