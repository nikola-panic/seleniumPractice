package dummyTests;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ZooTestLoggerClass extends AbstractWebDriverTest {

	private static final Logger logger = Logger.getLogger(ZooTestLoggerClass.class.getName());
	Handler fileHandler = null;
	Formatter formatter = null;

	@Before
	public void setUp1() throws SecurityException, IOException {
		fileHandler = new FileHandler("./zootest.log");
		formatter = new SimpleFormatter();
		fileHandler.setLevel(Level.ALL);
		fileHandler.setFormatter(formatter);
		logger.addHandler(fileHandler);
		logger.info("About to start the test");
	}

	@After
	public void tearDown() {
		logger.info("About to quit the driver");
	}

	@Test
	public void shouldBeAbleToSubmitForm() {
		logger.info("About to run the test");
		String name_field = "name_Test";
		String time_stamp = "01/01/1950 00:00:00";
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		driver.findElement(By.cssSelector("#contact_link")).click();
		driver.findElement(By.name("name_field")).sendKeys(name_field);
		driver.findElement(By.name("address_field")).sendKeys(time_stamp);
		driver.findElement(By.name("postcode_field")).sendKeys("test date");
		driver.findElement(By.name("email_field")).sendKeys("test@mail.com");
		driver.findElement(By.cssSelector("#submit_message")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("contact_confirm"));

		try {
			driver.findElement(By.cssSelector("#somethingNotExist")).click();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Severe issue occurered", e);
		}
	}

}