package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase{
	
	 @Test(dataProvider = "randomValidContactGenerator")
	  public void modifySomeContact(ContactData contact) throws Exception {
	    
	    // save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // Предусловие для выполнения теста: сущевствует хотя-бы один контакт!!!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    app.getContactHelper().modifyContact(index, contact, MODIFICATION);
	    
	    // save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare old and new states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	  }

}
