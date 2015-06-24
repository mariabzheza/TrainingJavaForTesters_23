package com.example.fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.tests.GroupData;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

//���������� ������ �� ����
public class JdbcHelper {

	private Connection conn;
	
	public JdbcHelper(ApplicationManager app, String url) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		//��� �� ������������� ���������� � ����� ������, � ����� ��� ����� ����� ��������������
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    //
	public SortedListOf<GroupData> listGroups() {
	//������������� ������� ������ �����
	  SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			// �������� ���������
			st = conn.createStatement();
			// ����������� sql ������ � ���� ������, ����������� ������� �������� ResultSet res
			res = st.executeQuery("SELECT group_id,group_name,group_header,group_footer FROM group_list");
			while (res.next()) {
			// ���������� ������ ���������������������� ������ ����� �������, ������� ����������� �� ���� ��������� (res.next()):
			// �� ������ ������� ����������� ������ ���� ��� groupId, ������ groupName,3-� groupHeader � 4-� groupFooter
			// � ���������� ��� ���� � ��������������� �������� GroupData. 
				GroupData gr = new GroupData().withId(res.getString(1)).withName(res.getString(2)).withHeader(res.getString(3)).withFooter(res.getString(4));
				groups.add(gr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				res.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return groups;
	}
	
    //
	public SortedListOf<ContactData> listContacts() {
	//������������� ������� ������ ���������
	  SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			// �������� ���������
			st = conn.createStatement();
			// ����������� sql ������ � ���� ������, ����������� ������� �������� ResultSet res
			//res = st.executeQuery("SELECT firstname,lastname,address,home,mobile,work,email,email2,bday,bmonth,byear,!!!!!new_group,address2,phone2,id FROM addressbook");
			res = st.executeQuery("SELECT firstname,lastname,address,home,mobile,work,email,email2,bday,bmonth,byear,address2,phone2,id FROM addressbook");
			while (res.next()) {
			// ���������� ������ ���������������������� ������ ��������� �������, ������� ����������� �� ���� ��������� (res.next()):
			// �� ������ ������� ����������� ������ ���� ��� contactId, ������ firstName,3-� lastName � �.�.
			// � ���������� ��� ���� � ��������������� �������� ContactData. 
				
				ContactData cont = new ContactData().withFirstName(res.getString(1)).withLastName(res.getString(2)).withAddress(res.getString(3))
						.withHomePhone(res.getString(4)).withMobilePhone(res.getString(5)).withWorkPhone(res.getString(6)).withFirstEmail(res.getString(7))
						.withSecondEmail(res.getString(8)).withBDay(res.getString(9)).withBMonth(res.getString(10)).withBYear(res.getString(11))
						.withSecondAddress(res.getString(12)).withSecondPhone(res.getString(13)).withId(res.getString(14));
				
				contacts.add(cont);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				res.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return contacts;
	}
	
}
