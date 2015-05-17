package com.example.fw;

//import static com.example.fw.ContactHelper.CREATION;
//import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cashedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cashedContacts == null) {
			rebuildCash();
		}
		return cashedContacts;
	}
	
	private void rebuildCash() {
		cashedContacts = new SortedListOf<ContactData>();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
		    ContactData contact = new ContactData()
		    	.withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
		    	.withLastName(row.findElement(By.xpath(".//td[2]")).getText())
		    	/*.withFirstEmail(row.findElement(By.xpath(".//td[4]")).getText())
		    	.withHomePhone(row.findElement(By.xpath(".//td[5]")).getText())*/;
		    cashedContacts.add(contact);
		}
	}

	public ContactHelper createContact(ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
    	initContactCreationForm();
    	fillContactForm(contact, CREATION);
    	submitContactCreationForm();
    	returnToHomePage();
    	rebuildCash();
    	return this;
	}
	
	public ContactHelper modifyContact(int indexOfContact, ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
    	initContactEditionDeletion(indexOfContact);
    	fillContactForm(contact, MODIFICATION);
    	submitModifiedContact();
    	returnToHomePage();
    	rebuildCash();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
    	initContactEditionDeletion(index);
    	clickDeleteContactButton();
    	returnToHomePage();
    	rebuildCash();
		return this;
	}
	
// ----------------------------------------------------------------------------------------------------------

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
		cashedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactEditionDeletion(int index) {
		//click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		return this;
	}

	public ContactHelper clickDeleteContactButton() {
		click(By.xpath("//input[@value='Delete']"));
		cashedContacts = null;
		return this;
	}

	public ContactHelper submitModifiedContact() {
		click(By.xpath("//input[@value='Update']"));
		//click(By.xpath("//input[@value='Update'AND@name='update']"));
		cashedContacts = null;
		return this;
	}
	
	private List<WebElement> getContactRows() {
		return driver.findElements(By.xpath("//tr[@name='entry']"));
	}
	
}
