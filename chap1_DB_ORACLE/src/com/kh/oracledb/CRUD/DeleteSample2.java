package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteSample2 {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khbank";
		String passWord = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, passWord);
			String deleteQuery = "DELETE FROM BANK  where account_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setDouble(1, 2);
			int rowsUpdate = deletePs.executeUpdate();
			System.out.println(rowsUpdate + " 업데이트 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
