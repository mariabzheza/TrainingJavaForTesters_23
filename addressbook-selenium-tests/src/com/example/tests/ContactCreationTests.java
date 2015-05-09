package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
   
    app.navigateTo().mainPage();
    
    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper()
    	.initContactCreationForm()
    	.fillContactForm(contact, CREATION)
    	.submitContactCreationForm()
    	.returnToHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare old and new states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }

}
