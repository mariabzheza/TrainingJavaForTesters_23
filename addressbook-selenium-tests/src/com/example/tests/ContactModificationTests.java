package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	 @Test
	  public void modifySomeContact() throws Exception {
	    
	    ContactData contact = new ContactData();
	    contact.first_name = "250first name 1";
	    contact.last_name = "250last name 1";
	    
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactModificationForm(1);
	    app.getContactHelper().fillContactForm(contact);
	    //
	    app.getContactHelper().submitContactCreationForm();
	    app.getContactHelper().returnToHomePage();
	    
	  }

}
