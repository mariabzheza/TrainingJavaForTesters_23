package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
//import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	  public Iterator<Object[]> groupsFromFile() throws IOException {
		  return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
		  //return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	  }

	@Test(dataProvider = "groupsFromFile")
  //@Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupGreationWithValidData(GroupData group) throws Exception {

	//app.navigateTo().mainPage();
    //app.navigateTo().groupsPage();
    
      // save old state
      SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
      // actions
      app.getGroupHelper().createGroup(group);
    
      // save new state
      SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
      // compare old and new state
      assertThat(newList, equalTo(oldList.withAdded(group)));
    }

}
