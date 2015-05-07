package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	  public void removeSomeContact() throws Exception {
	    
	    app.getNavigationHelper().openMainPage();
	    
	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // Предусловие для выполнения теста: сущевствует хотя-бы один контакт!!!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    app.getContactHelper().initContactEditDelete(index);
	    app.getContactHelper().deleteContact();
	    app.getContactHelper().returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare old and new states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	    
	    
	  }

}
