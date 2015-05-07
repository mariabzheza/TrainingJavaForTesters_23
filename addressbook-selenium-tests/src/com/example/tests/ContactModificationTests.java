package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	 @Test
	  public void modifySomeContact() throws Exception {
	    
	    ContactData contact = new ContactData();
	    contact.first_name = "250first name 1";
	    contact.last_name = "250last name 1";
	    
	    app.getNavigationHelper().openMainPage();
	    
	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions
	    app.getContactHelper().initContactEditDelete(0);
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitModifiedContact();
	    app.getContactHelper().returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare old and new states
	    
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	    
	  }

}
