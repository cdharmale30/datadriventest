package com.datadriventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestTestNG {
	@Parameters({ "url", "email" })
	@Test
	public void yahooTest(String url, String email) {

		//System.setProperty("webdriver.gecko.driver", "C:\\selib\\chromedriver.exe");
		// DesiredCapabilities dc = new DesiredCapabilities();
		System.setProperty("webdriver.gecko.driver", "C:\\selelib\\geckodriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("marionnete", false);
		FirefoxOptions opt = new FirefoxOptions();	//	fo.setCapability("marionatte", false);
		WebDriver driver = new FirefoxDriver(opt);
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).clear();

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(email);
		driver.findElement(By.id("login-signin")).click();

	}

}
