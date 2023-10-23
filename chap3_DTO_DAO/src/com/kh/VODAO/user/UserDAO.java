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
						 /*파라미터 값 추가*/
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
			return rows > 0; // 값이 들어오면 0보다 커지므로 true가 됨 
			
			
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
		//데이터베이스 리소스를 안전하게 사용하고 자동으로 닫아주기 위해서 사용되는 방법
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet result = st.executeQuery();//select 검색 쿼리문을 실행할 떄는 executeQuery() 메서드를 사용
			//selectOne if selectAll while
			while(result.next()) { //다음 레코드 행이 존재하면 while 반복문으로 처리 1개는 if 문
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

