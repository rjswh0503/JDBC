package com.kh.MVC.cafes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class menuDAO {
	
	private Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "153123";
	
	
	public menuDAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	
}
