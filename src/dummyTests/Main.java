package dummyTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public static void main (String[] args) {
		
		// Create an instance of webdriver
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Go to web page
		driver.navigate().to("http://www.thetestroom.com/webapp");
		
		
		// Click on the about link
		driver.findElement(By.id("about_link")).click();
		
		// Check that the about page has the about zoo title
		String title = driver.getTitle();
		
		if (title.equals("About Zoo")) {
			System.out.println("Found the about page with the " + title + " title");
		} else {
			System.out.println("Instead found page with the " + title + " title");
		}
		
		// Close the driver
		driver.close();
		
	}
	
}
