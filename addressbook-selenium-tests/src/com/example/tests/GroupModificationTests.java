package com.example.tests;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
	    
	    // save old state
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getModel().getGroups());
	    
	    // ����������� ��� ���������� �����: ����������� ����-�� ���� ������!!!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    app.getGroupHelper().modifyGroup(index, group);
	    
		// save new state
	    //SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
	    SortedListOf<GroupData> newList = app.getModel().getGroups();
	    
	    // compare old and new states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	    
	    // compare model to implementation
	    // ����� �������� ����� ��������� ���������� � �������� ��������
	    
	    if (wantToCheck()) {
	    	  
	    	//check.db �������� ���� �� ����� application.properties
	    	if ("yes".equals(app.getProperty("check.db"))) {
	    		// ���������� ������ � ���, ��� ����� � ���� ������
	            assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	    	}
	    	//check.ui �������� ���� �� ����� application.properties
	    	if ("yes".equals(app.getProperty("check.ui"))) {
	    		// ���������� ������ � ���, ��� ����� � UI
	        	assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
	    	}
	    }
	    
	}

}
