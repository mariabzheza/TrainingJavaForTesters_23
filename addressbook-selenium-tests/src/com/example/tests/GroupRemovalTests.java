package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup() {
	    
	    // save old state
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getModel().getGroups());
	    
	    // ѕредусловие дл€ выполнени€ теста: сущевствует хот€-бы одна группа!!!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
		app.getGroupHelper().deleteGroup(index);
		
		// save new state
		//SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
		SortedListOf<GroupData> newList = app.getModel().getGroups();
	    
	    // compare old and new states
		assertThat(newList, equalTo(oldList.without(index)));
		
	    // compare model to implementation
	    // таким способом можна управл€ть сложностью м частотой проверок
	    
		if (wantToCheck()) {
	    	  
	    	//check.db параметр берЄм из файла application.properties
	    	if ("yes".equals(app.getProperty("check.db"))) {
	    		// сравниваем модель с тем, что видим в базе данных
	            assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	    	}
	    	//check.ui параметр берЄм из файла application.properties
	    	if ("yes".equals(app.getProperty("check.ui"))) {
	    		// сравниваем модель с тем, что видим в UI
	        	assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
	    	}
	    }
		
	}

}
