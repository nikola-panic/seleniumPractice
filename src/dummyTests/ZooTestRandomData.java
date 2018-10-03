package dummyTests;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ZooTestRandomData extends AbstractWebDriverTest {

	@Test
	public void shouldBeAbleToSubmitForm() {
		driver.navigate().to("http://www.thetestroom.com/webapp/");
		driver.findElement(By.cssSelector("#contact_link")).click();
		driver.findElement(By.name("name_field")).sendKeys(randomString(10));
		driver.findElement(By.name("address_field")).sendKeys(timeStamp());
		driver.findElement(By.name("postcode_field")).sendKeys(String.valueOf(randomNumber(150)));
		driver.findElement(By.name("email_field")).sendKeys(randomEmail());
		driver.findElement(By.cssSelector("#submit_message")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("contact_confirm"));
	}

	public static String randomString(int length) {
		final String data = "0123456789abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(data.charAt(random.nextInt(data.length())));
		}
		return sb.toString();
	}

	public static String randomEmail() {
		int length = 5;
		String name = "0123456789abcdefghijklmnopqrstuvwxyz";
		String firstDomain = "0123456789abcdefghijklmnopqrstuvwxyz";
		String secondDomain = "abcdefghijklmnopqrstuvwxyz";

		Random random = new Random();
		String email = new String();

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(name.charAt(random.nextInt(name.length())));
		}
		email += sb;

		sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(firstDomain.charAt(random.nextInt(firstDomain.length())));
		}
		email += "@" + sb;

		sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(secondDomain.charAt(random.nextInt(secondDomain.length())));
		}
		email += "." + sb;

		return email;
	}

	public static int randomNumber(int maxValue) {
		Random random = new Random();
		return random.nextInt(maxValue);
	}

	public static String timeStamp() {
		Date date = new Date();
		return new Timestamp(date.getTime()).toString();
	}

}