package dummyTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactFormTest extends AbstractTestDriver {

	@Test
	public void shouldPopulateForm() {
		// Navigate to Zoo Site
		driver.navigate().to("http://www.thetestroom.com/webapp");

		// Click on Contact Form
		driver.findElement(By.id("contact_link")).click();

		// Populate Contact Form
		driver.findElement(By.name(property.contactFormNameField)).sendKeys(property.contactNameValue);
		driver.findElement(By.name("address_field")).sendKeys("address test");
		driver.findElement(By.name("postcode_field")).sendKeys("postcode test");
		driver.findElement(By.name("email_field")).sendKeys("email test");

		// Submit Contact form
		driver.findElement(By.id("submit_message")).click();

		// Check Contact Form has been subbmited
		Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("Many thanks for your message"));
	}

}
