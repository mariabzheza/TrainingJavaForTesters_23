package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreationForm() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		
		type(By.name("firstname"), contact.first_name);
		type(By.name("lastname"), contact.last_name);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home_phone);
		type(By.name("mobile"), contact.mobile_phone);
		type(By.name("work"), contact.work_phone);
		type(By.name("email"), contact.first_email);
		type(By.name("email2"), contact.second_email);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"), contact.byear);
	    //new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.new_group);
	    selectByText(By.name("new_group"), contact.new_group);
	    type(By.name("address2"), contact.second_address);
	    type(By.name("phone2"), contact.second_phone);
	}
	
	public void submitContactCreationForm() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactEditDelete(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void submitModifiedContact() {
		click(By.xpath("//input[@value='Update']"));
		//click(By.xpath("//input[@value='Update'AND@name='update']"));
	}

}
