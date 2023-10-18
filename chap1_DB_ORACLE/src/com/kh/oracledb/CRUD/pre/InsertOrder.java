package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOrder {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khCafe";
		String passWord = "153123";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, passWord);
			System.out.println("DB 연동 성공!");
			String InsertSQL = "INSERT INTO orders(o_id,cafe_id,menu_id,o_date,quantity,total_price)"
								+ "VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(InsertSQL);
			
			InsertOrder(ps,36,7,10,Date.valueOf("2023-10-18"),4,7.5);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	public static void InsertOrder(PreparedStatement ps,int o_id, int cafe_id, int menu_id,Date o_date,int quantity, double total_price) throws SQLException {
		
		ps.setInt(1, o_id);
		ps.setInt(2, cafe_id);
		ps.setInt(3, menu_id);
		ps.setNull(4, java.sql.Types.DATE);
		ps.setInt(5, quantity);
		ps.setDouble(6, total_price);
		
		ps.executeUpdate();
		System.out.println("추가 완료");
		
		
	}
}
