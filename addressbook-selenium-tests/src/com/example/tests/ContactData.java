package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String first_name;
	private String last_name;
	private String address;
	private String home_phone;
	private String mobile_phone;
	private String work_phone;
	private String first_email;
	private String second_email;
	private String bday;
	private String bmonth;
	private String byear;
	private String new_group;
	private String second_address;
	private String second_phone;
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
		return "ContactData [first_name=" + first_name + ", last_name="
				+ last_name + "]";
	}

	@Override
	// возможно тут надо будет ещё исправить, если в адресной книге сортировка сделана по-другому.
	public int compareTo(ContactData other) {
		int result = this.last_name.toLowerCase().compareTo(other.last_name.toLowerCase());
		if (result == 0) {
			result = this.first_name.toLowerCase().compareTo(other.first_name.toLowerCase());
			/*if (result == 0) {
				result = this.home_phone.toLowerCase().compareTo(other.home_phone.toLowerCase());
				if (result == 0) {
					result = this.first_email.toLowerCase().compareTo(other.first_email.toLowerCase());
				}
			}*/
		}
		
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//пока убираем сравнение по хеш-коду, в данном случае будет выполняться только метод equals 
		/*
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		*/
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
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}
	
	// Some Setters bellow
	public ContactData withFirstName(String firstName) {
		first_name = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		last_name = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		home_phone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		mobile_phone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		work_phone = workPhone;
		return this;
	}

	public ContactData withFirstEmail(String firstEmail) {
		first_email = firstEmail;
		return this;
	}

	public ContactData withSecondEmail(String secondEmail) {
		second_email = secondEmail;
		return this;
	}

	public ContactData withBDay(String bDay) {
		bday = bDay;
		return this;
	}

	public ContactData withBMonth(String bMonth) {
		bmonth = bMonth;
		return this;
	}

	public ContactData withBYear(String bYear) {
		byear = bYear;
		return this;
	}

	public ContactData withNewGroup(String newGroup) {
		new_group = newGroup;
		return this;
	}

	public ContactData withSecondAddress(String secondAddress) {
		second_address = secondAddress;
		return this;
	}

	public ContactData withSecondPhone(String secondPhone) {
		second_phone = secondPhone;
		return this;
	}

	// Some Getters bellow
	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAddress() {
		return address;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public String getFirst_email() {
		return first_email;
	}

	public String getSecond_email() {
		return second_email;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getNew_group() {
		return new_group;
	}

	public String getSecond_address() {
		return second_address;
	}

	public String getSecond_phone() {
		return second_phone;
	}
	
}