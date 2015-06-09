package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exist, please remove it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format " + format);
			return;
		}

	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		// тут ещЄ надо доделать!!!!!
		
		/*FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirst_name() + "," + contact.getLast_name() + "," + contact.getAddress() + "," + contact.getHome_phone() + "," + contact.getMobile_phone() + "," + contact.getWork_phone() + "," + contact.getFirst_email() + "," + contact.getSecond_email() + "," + contact.getBday() + "," + contact.getBmonth() + "," + contact.getByear() + "," + contact.getNew_group() + "," + contact.getSecond_address() + "," + contact.getSecond_phone() + "\n");
		}
		writer.close();
		*/
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirst_name() + "," + contact.getLast_name() + "," + contact.getAddress() + "," + contact.getHome_phone() + "," + contact.getMobile_phone() + "," + contact.getWork_phone() + "," + contact.getFirst_email() + "," + contact.getSecond_email() + "," + contact.getBday() + "," + contact.getBmonth() + "," + contact.getByear() + "," + contact.getNew_group() + "," + contact.getSecond_address() + "," + contact.getSecond_phone() + "\n");
		}
		writer.close();
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		  
		  for (int i =0; i < amount; i++) {
			  ContactData contact = new ContactData()
			  	.withFirstName(generateRandomString())
			  	.withLastName(generateRandomString())
			  	.withAddress(generateRandomString())
			  	.withHomePhone(generateRandomString())
			  	.withMobilePhone(generateRandomString())
			  	.withWorkPhone(generateRandomString())
			  	.withFirstEmail(generateRandomString())
			  	.withSecondEmail(generateRandomString())
			  	.withBDay("-")
			  	.withBMonth("-")
			  	.withBYear("2004")
			 // ѕринадлежность контакта к group есть при операции create, но почему-то нету при edit, возможно, что надо следующую строчку закоментировать.
			  	.withNewGroup("[none]")
			  	.withSecondAddress(generateRandomString())
			  	.withSecondPhone(generateRandomString());
			  
			  list.add(contact);  
		  }
		  return list;
	}
	
	  public static String generateRandomString() {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "";  
		  } else {
			  return "test" + rnd.nextInt();
		  }
	  }
}
