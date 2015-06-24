package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

//import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase{
	
	@Test
	  public void removeSomeContact() throws Exception {
	    
	    // save old state
	    //SortedListOf<ContactData> oldList = app.getContactHelper().getUiContacts();
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getModel().getContacts());
	    
	    // ����������� ��� ���������� �����: ����������� ����-�� ���� �������!!!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    app.getContactHelper().deleteContact(index);
	    
	    // save new state
	    //SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();
	    SortedListOf<ContactData> newList = app.getModel().getContacts();
	    
	    // compare old and new states
	    assertThat(newList, equalTo(oldList.without(index)));
	    
	    // compare model to implementation
	    // ����� �������� ����� ��������� ���������� � �������� ��������
	    
		if (wantToCheck()) {
	    	  
	    	//check.db �������� ���� �� ����� application.properties
	    	if ("yes".equals(app.getProperty("check.db"))) {
	    		// ���������� ������ � ���, ��� ����� � ���� ������
	            assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
	    	}
	    	//check.ui �������� ���� �� ����� application.properties
	    	if ("yes".equals(app.getProperty("check.ui"))) {
	    		// ���������� ������ � ���, ��� ����� � UI
	        	assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));
	    	}
	    }
	    
	  }

}
