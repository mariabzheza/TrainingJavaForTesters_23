package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

import com.example.tests.GroupData;

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
      //SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
      //SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	  //SortedListOf<GroupData> oldList = app.getModel().getGroups();
	  SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getModel().getGroups());
    
      // actions
      app.getGroupHelper().createGroup(group);
    
      // save new state
      //SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
      SortedListOf<GroupData> newList = app.getModel().getGroups();
    
      // compare old and new state
      assertThat(newList, equalTo(oldList.withAdded(group)));
      
      // compare model to implementation
      // таким способом можна управлять сложностью м частотой проверок
      
      if (wantToCheck()) {
    	  
    	  //check.db параметр берём из файла application.properties
    	  if ("yes".equals(app.getProperty("check.db"))) {
    		  // сравниваем модель с тем, что видим в базе данных
              assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
    	  }
    	  //check.ui параметр берём из файла application.properties
    	  if ("yes".equals(app.getProperty("check.ui"))) {
    		  // сравниваем модель с тем, что видим в UI
        	  assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
    	  }
      }
      
    }

}
