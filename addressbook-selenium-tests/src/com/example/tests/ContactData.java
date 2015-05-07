package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String first_name;
	public String last_name;
	public String address;
	public String home_phone;
	public String mobile_phone;
	public String work_phone;
	public String first_email;
	public String second_email;
	public String bday;
	public String bmonth;
	public String byear;
	public String new_group;
	public String second_address;
	public String second_phone;
//	public String firstAndLastName ="";

	public ContactData() {
	}
	
	public ContactData(String first_name, String last_name, String address,
			String home_phone, String mobile_phone, String work_phone,
			String first_email, String second_email, String bday,
			String bmonth, String byear, String new_group,
			String second_address, String second_phone) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.home_phone = home_phone;
		this.mobile_phone = mobile_phone;
		this.work_phone = work_phone;
		this.first_email = first_email;
		this.second_email = second_email;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.new_group = new_group;
		this.second_address = second_address;
		this.second_phone = second_phone;
	}
	
	@Override
	public String toString() {
		return "ContactData [first_name=" + first_name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//пока убираем сравнение по хеш-коду, в данном случае будет выполняться только метод equals 
		//result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.first_name.toLowerCase().compareTo(other.first_name.toLowerCase());
	}
}