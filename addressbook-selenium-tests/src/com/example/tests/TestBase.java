package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	  public Iterator<Object[]> randomValidGroupGenerator() {
		  
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i =0; i < 5; i++) {
			  GroupData group = new GroupData();
			  group.name = generateRandomString();
			  group.header = generateRandomString();
			  group.footer = generateRandomString();
			  list.add(new Object[]{group});
		  }
		  return list.iterator();
	  }
	  
	@DataProvider
	  public Iterator<Object[]> randomValidContactGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i =0; i < 5; i++) {
			  ContactData contact = new ContactData();
			  contact.first_name = generateRandomString();
			  contact.last_name = generateRandomString();
			  contact.address = generateRandomString();
			  contact.home_phone = generateRandomString();
			  contact.mobile_phone = generateRandomString();
			  contact.work_phone = generateRandomString();
			  contact.first_email = generateRandomString();
			  contact.second_email = generateRandomString();
			  contact.bday = "-";
			  contact.bmonth = "-";
			  contact.byear = "2004";
			  // Принадлежность контакта к group есть при операции create, но почему-то нету при edit, по-этому закоментировано.
			  //contact.new_group = "[none]";
			  contact.second_address = generateRandomString();
			  contact.second_phone = generateRandomString();
			  list.add(new Object[]{contact});  
		  }
		  return list.iterator();
	  }
	  
	  public String generateRandomString() {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "";  
		  } else {
			  return "test" + rnd.nextInt();
		  }
	  }
  
}
