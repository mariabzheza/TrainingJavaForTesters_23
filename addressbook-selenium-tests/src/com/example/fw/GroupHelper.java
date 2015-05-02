package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
		  click(By.name("new"));
	  }

	public void fillGroupForm(GroupData group) {
		  type(By.name("group_name"), group.name);
		  type(By.name("group_header"), group.header);
		  type(By.name("group_footer"), group.footer);
	  }

	public void submitGroupCreationForm() {
		  //driver.findElement(By.name("submit")).click();
		  click(By.name("submit"));
	  }

	public void returnToGroupsPage() {
		  //driver.findElement(By.linkText("group page")).click();
		  click(By.linkText("group page"));
	  }

}
