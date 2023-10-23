package com.kh.VODAO.user2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDAO {
	
	private Connection connection;
	
	
	
	public UserDAO(Connection connection) {
		this.connection = connection;
		
	}
	
	public boolean CreateUser(UserVO user) {
		String sql = "INSERT INTO USERS(user_id,username,userpassword,reg_date)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUser_id());
			st.setString(2, user.getUsername());
			st.setString(3, user.getUserpassword());
			st.setDate(4, new Date(user.getReg_Date().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
