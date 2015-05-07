package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    
    ContactData contact = new ContactData();
    contact.first_name = "first name 1";
    contact.last_name = "last name 1";
    contact.address = "address 1";
    contact.home_phone = "home phone 1";
    contact.mobile_phone = "mobile phone 1";
    contact.work_phone = "work phone 1";
    contact.first_email = "first email";
    contact.second_email = "second email";
    contact.bday = "1";
    contact.bmonth = "January";
    contact.byear = "2010";
    contact.new_group = "name 1";
    contact.second_address = "second address 1";
    contact.second_phone = "second phone 1";
    
    app.getNavigationHelper().openMainPage();
    
    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper().initContactCreationForm();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreationForm();
    app.getContactHelper().returnToHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare old and new states
    
    //assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	
    ContactData contact = new ContactData();
    contact.first_name = "";
    contact.last_name = "";
    contact.address = "";
    contact.home_phone = "";
    contact.mobile_phone = "";
    contact.work_phone = "";
    contact.first_email = "";
    contact.second_email = "";
    contact.bday = "-";
    contact.bmonth = "-";
    contact.byear = "";
    contact.new_group = "[none]";
    contact.second_address = "";
    contact.second_phone = "";
    
    app.getNavigationHelper().openMainPage();
    
    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper().initContactCreationForm();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreationForm();
    app.getContactHelper().returnToHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare old and new states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }

}
