package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;
   
public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cashedGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cashedGroups == null) {
			rebuildCash();
		}
		return cashedGroups;
	}
	
	private void rebuildCash() {
		//SortedListOf<GroupData> cashedGroups = new SortedListOf<GroupData>();
		cashedGroups = new SortedListOf<GroupData>();
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			//GroupData group = new GroupData().withName(name);
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cashedGroups.add(new GroupData().withName(name));
		}	
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
    	initGroupCreation();
    	fillGroupForm(group);
    	submitGroupCreationForm();
    	returnToGroupsPage();
    	rebuildCash();
    	return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		rebuildCash();
		return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCash();
		return this;
	}
	
//-------------------------------------------------------------------------------------

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	  }

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	  }
	
	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupCreationForm() {
		//driver.findElement(By.name("submit")).click();
		click(By.name("submit"));
		cashedGroups = null;
		return this;
	  }

	public GroupHelper returnToGroupsPage() {
		//driver.findElement(By.linkText("group page")).click();
		click(By.linkText("group page"));
		return this;
	  }

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cashedGroups = null;
		return this;
	}
	
	public void submitGroupDeletion() {
		click(By.name("delete"));
		cashedGroups = null;
	}

}
