package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    goByLinkToInitContactCreationForm();
    
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
    
	fillContactForm(contact);
    submitGroupAndContactForms();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    goByLinkToInitContactCreationForm();
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
    
	fillContactForm(contact);
    submitGroupAndContactForms();
    returnToHomePage();
  }

}
