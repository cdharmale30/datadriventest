package com.datadriventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.xlsreader.utility.Xls_Reader;

public class DataDrivenTest {
	public static WebDriver driver;

	public static void main(String[] args) {
		// driver= new FirefoxDriver();
		// driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2Fsch%2Fi.html%3F_nkw%3Debay%2Bfor%26ul_noapp%3Dtrue");
		System.out.println(1);
		Xls_Reader reader = new Xls_Reader("I:\\All Eclipse Code6\\DataDriven\\testdata.xlsx");
		String firstName = reader.getCellData("RegisterData", "firstname", 2);
		System.out.println(firstName);

		String lastName = reader.getCellData("RegisterData", "lastname", 2);
		System.out.println(lastName);

		String eMail = reader.getCellData("RegisterData", "email", 2);
		System.out.println(eMail);

		String passWord = reader.getCellData("RegisterData", "password", 2);
		System.out.println(passWord);

		System.out.println(55555);
		
		System.setProperty("webdriver.firefox.marionette", "C:\\selelib\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		

		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2Fsch%2Fi.html%3F_nkw%3Debay%2Bfor%26ul_noapp%3Dtrue");
		System.out.println(88888);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);;

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(eMail);;
		driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys(passWord);;

		
		driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).click();
	
		
	}
}