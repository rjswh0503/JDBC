package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSample {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khbank";
		String passWord = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, passWord);
			String updateQuery = "UPDATE BANK SET balance = ? where account_number = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setDouble(1, 2500.00);
			updatePs.setString(2, "1234567890");
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + " 업데이트 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
