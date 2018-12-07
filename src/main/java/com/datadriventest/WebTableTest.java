package com.datadriventest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.xlsreader.utility.Xls_Reader;

public class WebTableTest {
	WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\selelib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		String before_xpath_company = "//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath_company = "]/td[1]";

		String before_xpath_contact = "//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath_contact = "]/td[2]";

		String before_xpath_country = "//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath_country = "]/td[3]";

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total no of rows" + (rows.size() - 1));
		int rowCount = rows.size();

		Xls_Reader reader = new Xls_Reader("I:\\All Eclipse Code6\\DataDriven\\testdata.xlsx");

		if (!reader.isSheetExist("TestData")) {
			reader.addSheet("TestData");
		}

		reader.addColumn("TestData", "CompanyName");
		reader.addColumn("TestData", "ContactName");

		reader.addColumn("TestData", "CountryName");

		for (int i = 2; i <= rowCount; i++) {
			String actual_xpath_company = before_xpath_company + i + after_xpath_company;
			String companyName = driver.findElement(By.xpath(actual_xpath_company)).getText();
			System.out.println(companyName);
			reader.setCellData("TestData", "CompanyName", i, companyName);

			String actual_xpath_contact = before_xpath_contact + i + after_xpath_contact;
			String contactName = driver.findElement(By.xpath(actual_xpath_contact)).getText();
			System.out.println(contactName);
			reader.setCellData("TestData", "ContactName", i, contactName);

			String actual_xpath_country = before_xpath_country + i + after_xpath_country;
			String countryName = driver.findElement(By.xpath(actual_xpath_country)).getText();
			System.out.println(countryName);

			reader.setCellData("TestData", "CountryName", i, countryName);

		}
	}

}
