package PageObjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage navigateToSite() {
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		return new HomePage(driver);
	}

}
