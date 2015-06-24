package com.example.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.fw.ApplicationManager;
import com.example.fw.JdbcHelper;

public class Sample3 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//String configFile = System.getProperty("configFile","application.properties");
		Properties properties = new Properties();
		//properties.load(new FileReader(new File(configFile)));
		properties.load(new FileReader(new File("application.properties")));
		ApplicationManager app = new ApplicationManager(properties);
		//якщо використовується дефолтний порт, то його можна не прописувати в наступному рядку
		JdbcHelper jdbc = new JdbcHelper(app, "jdbc:mysql://localhost/addressbook?user=root&password=");
		System.out.println(jdbc.listGroups());
		//app.get
	}

}