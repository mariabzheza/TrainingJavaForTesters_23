package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;




import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.fw.ContactHelper.CREATION;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactCreationTests extends TestBase {
	
	@DataProvider
	  public Iterator<Object[]> contactsFromFile() throws IOException {
		  //return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		  return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	  }

	@Test(dataProvider = "contactsFromFile")
  //@Test(dataProvider = "randomValidContactGenerator")
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
