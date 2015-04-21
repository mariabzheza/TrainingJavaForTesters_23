package com.example.tests;

public class ContactData {
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
}