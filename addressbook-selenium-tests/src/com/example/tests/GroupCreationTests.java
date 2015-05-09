package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

//в следующей строке из класса Assert импортируется отдельний метод assertEquals
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
  
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupGreationWithValidData(GroupData group) throws Exception {

	//app.navigateTo().mainPage();
    //app.navigateTo().groupsPage();
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper()
    	.initGroupCreation()
    	.fillGroupForm(group)
    	.submitGroupCreationForm()
    	.returnToGroupsPage();
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare old and new state
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }

}
