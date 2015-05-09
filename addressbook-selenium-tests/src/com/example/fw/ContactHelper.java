package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper initContactCreationForm() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		
		type(By.name("firstname"), contact.getFirst_name());
		type(By.name("lastname"), contact.getLast_name());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome_phone());
		type(By.name("mobile"), contact.getMobile_phone());
		type(By.name("work"), contact.getWork_phone());
		type(By.name("email"), contact.getFirst_email());
		type(By.name("email2"), contact.getSecond_email());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    
	    // Принадлежность контакта к group есть при операции create, но почему-то нету при edit, см. коммент "Проверка" ниже.
	    //new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.new_group);
	    
	    if (formType == CREATION) {
	    	selectByText(By.name("new_group"), contact.getNew_group());
	    } else {
	    	// Проверка: если это не форма для создания группы, и если на странице присутствует елемент для выбора форм, то это ошибка!!!
	    	// Но из-за этой проверки тесты тормозят сильно!!!
	    	if (driver.findElements(By.name("new_group")).size() !=0) {
	    		throw new Error("Group selector exist in contact modification form");
	    	}
	    }
	    
	    type(By.name("address2"), contact.getSecond_address());
	    type(By.name("phone2"), contact.getSecond_phone());
	    
	    return this;
	}
	
	public ContactHelper submitContactCreationForm() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactEditDelete(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		return this;
	}

	public ContactHelper deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		return this;
	}

	public ContactHelper submitModifiedContact() {
		click(By.xpath("//input[@value='Update']"));
		//click(By.xpath("//input[@value='Update'AND@name='update']"));
		return this;
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		
/*
		List<WebElement> contactElements = driver.findElements(By.name("selected[]"));
		for (WebElement contactElement: contactElements){
			ContactData contact = new ContactData();
			String title = contactElement.getAttribute("title");
			contact.firstAndLastName = title.substring("Select (".length(), title.length() - ")".length());
			contacts.add(contact);
		}		
*/	
		
/*
 * 		String path = "//tr[td[text()='" + firstname + "'] and td[text()='250first name 1']]";
 *      //tr[td[text()='250last name 1'] and td[text()='250first name 1']]
*/
		
		List<WebElement> firstnameLists = driver.findElements(By.xpath("//tr[@name='entry'][*]/td[3]"));
		for(WebElement firstname: firstnameLists) {
			String first_name = firstname.getText();
			contacts.add(new ContactData().withFirstName(first_name));
		}
				
		return contacts;
	}
	
}
