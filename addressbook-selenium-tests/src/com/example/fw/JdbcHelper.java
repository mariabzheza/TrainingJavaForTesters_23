package com.example.fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

//Извлечение данных из базы
public class JdbcHelper {

	private Connection conn;
	
	public JdbcHelper(ApplicationManager app, String url) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		//тут мы устанавливаем соединение с базой данных, и потом оно всюду будет использоваться
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    //
	public SortedListOf<GroupData> listGroups() {
	//инициализация пустого списка групп
	  SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			// создаётся стейтмент
			st = conn.createStatement();
			// выполняется sql запрос к базе данных, результатом запроса является ResultSet res
			res = st.executeQuery("SELECT group_id,group_name,group_header,group_footer FROM group_list");
			while (res.next()) {
			// Заполнение раньше проинициализированного списка групп данными, которые извлекаются из базы построчно (res.next()):
			// Из каждой строчки извлекается первое поле это groupId, второе groupName,3-е groupHeader и 4-е groupFooter
			// и помещаются эти поля в соответствующие атрибуты GroupData. 
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
}
