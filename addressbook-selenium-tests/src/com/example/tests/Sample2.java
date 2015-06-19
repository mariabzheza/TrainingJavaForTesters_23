package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get("www.google.com");
		driver.navigate().to("http://selenium.org/");
		driver.quit();
	}

}
