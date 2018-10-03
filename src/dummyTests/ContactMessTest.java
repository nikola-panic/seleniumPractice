package dummyTests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PageObjects.ContactPage;
import PageObjects.ContactResultPage;

public class ContactMessTest extends AbstractWebDriverTest {

	@BeforeEach
	public void testSetUp() {
		onHomePage.navigateToSite();
		// Create an instance of webdriver
		System.out.println("before in test");

	}

	@Test
	public void shouldSendContactMessage() {
		ContactPage onContactPage = onHomePage.ClickOnContact();
		ContactResultPage onResultPage = onContactPage.fillFormWithData().submitForm();

		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("Many thanks for your message"));
	}

}
