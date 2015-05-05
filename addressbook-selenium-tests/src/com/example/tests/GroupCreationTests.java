package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

//� ��������� ������ �� ������ Assert ������������� ��������� ����� assertEquals
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
  
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupGreationWithValidData(GroupData group) throws Exception {

	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreationForm();
    app.getGroupHelper().returnToGroupsPage();
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare old and new states
    
    /* ��� �������� �������, ��� ��� ��� �������� ������ �������� (������ �� �������), 
     * � �� ��������� ��� ��� ������ ��������� assert 
     * assertEquals(newList.size(), oldList.size() + 1);
    */
    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }

}
