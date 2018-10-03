package dummyTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ZooTestFailedTestRule extends AbstractWebDriverTest {

	@Before
	public void navigate() {
		driver.navigate().to("http://www.thetestroom.com/webapp/");
	}

	@Test
	public void shouldBeAbleToSeeTitleOnHomePage() {
		Assert.assertTrue(driver.getTitle().contains("Home"));
	}

	@Test
	public void shouldBeAbleToSeeTitleOnAdoptionPage() {
		driver.findElement(By.cssSelector("#adoption_link")).click();
		Assert.assertTrue(driver.getTitle().contains("VideosOnAutomation"));
	}

	@Rule
	public TestRule listen = new TestWatcher() {
		@Override
		public void failed(Throwable t, Description description) {
			try {
				takeScreenShot(description.getClassName() + ", " + description.getMethodName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};

	public void takeScreenShot(String name) throws IOException {
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File("screenshot/" + name + ".png"));
	}

}