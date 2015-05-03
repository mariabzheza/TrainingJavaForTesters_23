package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	  public void removeSomeContact() throws Exception {
	    
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactEditDelete(1);
	    app.getContactHelper().deleteContact();
	    app.getContactHelper().returnToHomePage();
	    
	  }

}
