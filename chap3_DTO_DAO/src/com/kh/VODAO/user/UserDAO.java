package com.kh.VODAO.user;

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
						 /*�Ķ���� �� �߰�*/
	public boolean createUser(UserVO user) {
		String sql = "INSERT INTO USERINFO(user_id, userName, email, reg_date)"
					+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUser_id());
			st.setString(2, user.getUserName());
			st.setString(3, user.getEmail());
			st.setDate(4, new Date(user.getRegDate().getTime()));
	
			int rows = st.executeUpdate();
			return rows > 0; // ���� ������ 0���� Ŀ���Ƿ� true�� �� 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}	
		
		
		
		
	}
	
	
	public List<UserVO> getAllUser() {
		List<UserVO> users = new ArrayList<>();
		
		String sql = "Select * from userInfo";
		//try - with - resources 
		//�����ͺ��̽� ���ҽ��� �����ϰ� ����ϰ� �ڵ����� �ݾ��ֱ� ���ؼ� ���Ǵ� ���
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet result = st.executeQuery();//select �˻� �������� ������ ���� executeQuery() �޼��带 ���
			//selectOne if selectAll while
			while(result.next()) { //���� ���ڵ� ���� �����ϸ� while �ݺ������� ó�� 1���� if ��
				UserVO user = new UserVO();
				user.setUser_id(result.getInt("user_id"));
				user.setUserName(result.getString("userName"));
				user.setEmail(result.getString("email"));
				user.setRegDate(result.getDate("reg_date"));
				users.add(user);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	
	}

}

