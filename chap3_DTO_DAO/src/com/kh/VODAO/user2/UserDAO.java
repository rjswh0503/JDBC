package com.kh.VODAO.user2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
	
	
	public List<UserVO> getAllUser(){
		List<UserVO> users = new ArrayList<>();
		String sql = "Select * from users";
		
		try {
			PreparedStatement pt = connection.prepareStatement(sql);
			ResultSet result = pt.executeQuery();
			while(result.next()){
				UserVO user = new UserVO();
				user.setUser_id(result.getInt("user_id"));
				user.setUsername(result.getString("userName"));
				user.setUserpassword(result.getString("userpassword"));
				user.setReg_Date(result.getDate("reg_date"));
				users.add(user);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
		
	}

}
