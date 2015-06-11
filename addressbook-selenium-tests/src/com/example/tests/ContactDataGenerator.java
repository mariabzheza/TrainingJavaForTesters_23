package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

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

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		//добавляем следующую строку, если хотим, чтобы в contacts.xml тег <com.example.tests.ContactData> виглядел так: <contact>
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		//добавляем следующую строку, если хотим, чтобы в contacts.xml тег <com.example.tests.ContactData> виглядел так: <contact>
		xstream.alias("contact", ContactData.class);
		
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirst_name() + "," + contact.getLast_name() + "," + contact.getAddress() + "," + contact.getHome_phone() + "," + contact.getMobile_phone() + "," + contact.getWork_phone() + "," + contact.getFirst_email() + "," + contact.getSecond_email() + "," + contact.getBday() + "," + contact.getBmonth() + "," + contact.getByear() + "," + contact.getNew_group() + "," + contact.getSecond_address() + "," + contact.getSecond_phone() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
				.withFirstName(part[0])
				.withLastName(part[1])
				.withAddress(part[2])
				.withHomePhone(part[3])
			  	.withMobilePhone(part[4])
			  	.withWorkPhone(part[5])
			  	.withFirstEmail(part[6])
			  	.withSecondEmail(part[7])
			  	.withBDay(part[8])
			  	.withBMonth(part[9])
			  	.withBYear(part[10])
			  	.withNewGroup(part[11])
			  	.withSecondAddress(part[12])
			  	.withSecondPhone(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
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
			 // Принадлежность контакта к group есть при операции create, но почему-то нету при edit, возможно, что надо следующую строчку закоментировать.
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
