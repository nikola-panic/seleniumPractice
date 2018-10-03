package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactResultPage extends AbstractPage {

	public ContactResultPage(WebDriver driver) {
		super(driver);
	}

	public String getConfirmationMessage() {
		return driver.findElement(By.tagName("p")).getText();
	}

}
