package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase{
	
	 @Test(dataProvider = "randomValidContactGenerator")
	  public void modifySomeContact(ContactData contact) throws Exception {
	    
	    app.navigateTo().mainPage();
	    
	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // ����������� ��� ���������� �����: ����������� ����-�� ���� �������!!!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    app.getContactHelper()
	    	.initContactEditDelete(index)
	    	.fillContactForm(contact, MODIFICATION)
	    	.submitModifiedContact()
	    	.returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare old and new states
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	    
	  }

}
