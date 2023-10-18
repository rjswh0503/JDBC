package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert 작성해서 여러 카페 추가하기
public class InsertExam {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passWord = "153123";
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, passWord);
			String insertSQL = "INSERT INTO cafes (cafe_id,c_name,c_address,phone_number,operating_hours)"
								+ "VALUES (?,?,?,?,?)";
			PreparedStatement ps1 = con.prepareStatement(insertSQL);
			
			insertCafes(ps1,21,"메갓코히","경기도 안산시","031-452-2458","매일: 09:00 ~ 21:00");
			insertCafes(ps1,22,"cafes","전라북도 전주시","062-123-4567","매일: 07:00 ~ 20:30");
			insertCafes(ps1,23,"카페커피","경기도 안양시","031-456-7845","매일: 08:30 ~ 21:30");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	public static void insertCafes(PreparedStatement ps1, int cafe_id, String c_name,String c_address,String phone_number,String operating_hours) throws SQLException {
		ps1.setInt(1, cafe_id);
		ps1.setString(2, c_name);
		ps1.setString(3, c_address);
		ps1.setString(4, phone_number);
		ps1.setString(5, operating_hours);
		int rowsInsert = ps1.executeUpdate();
		System.out.println(rowsInsert + " 추가 완료");
		
	}
}
