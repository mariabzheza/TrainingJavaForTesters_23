package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactCreationTests extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
   
    //app.navigateTo().mainPage();
    
    // save old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
    app.getContactHelper().createContact(contact, CREATION);
    
    // save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare old and new states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }

}
