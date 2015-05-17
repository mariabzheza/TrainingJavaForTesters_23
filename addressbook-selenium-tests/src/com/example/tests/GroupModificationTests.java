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
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // Предусловие для выполнения теста: сущевствует хотя-бы одна группа!!!
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    app.getGroupHelper().modifyGroup(index, group);
	    
		// save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare old and new states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}

}
