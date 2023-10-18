package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAll {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khbank";
		String passWord = "1234";
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, passWord);
			String insertSQL = "INSERT INTO bank(account_id,account_number,account_name,balance,branch_name,last_Transaction_date)"
							+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			//"products"테이블에 데이터 삽입
			insertBank(ps,15,1236548524,"라마바",1500.00,"서쪽지점",Date.valueOf("2023-10-16"));
			
			
			ps.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	static void insertBank(PreparedStatement ps, int account_id, int account_number, String account_name,double balance,String branch_name,Date last_transaction_date) throws SQLException {
		ps.setInt(1, account_id);
		ps.setInt(2, account_number);
		ps.setString(3, account_name);
		ps.setDouble(4, balance);
		ps.setString(5, branch_name);
		ps.setDate(6, last_transaction_date);
		ps.executeUpdate();
		
		
	}

	

	
}
