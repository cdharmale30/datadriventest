package com.datadriventest;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class HalfEbayTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.firefox.marionette", "C:\\selelib\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2Fsch%2Fi.html%3F_nkw%3Debay%2Bfor%26ul_noapp%3Dtrue");
		System.out.println(88888);

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();

	}

	@Test(dataProvider="getTestData")
	public void ebayRegisterData(String firstname, String lastname, String email, String password) {
		driver.findElement(By.xpath("//input[@id='firstname']")).clear();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='lastname']")).clear();
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='PASSWORD']")).clear();
		driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}
