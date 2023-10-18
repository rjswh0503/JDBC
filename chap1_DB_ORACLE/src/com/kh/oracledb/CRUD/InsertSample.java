package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class InsertSample {

	public static void main(String[] args) {
		
		
		//InsertBank2();
		//Insertkhcafe();
		//Insertkhcafe1();
		
		
	}
	

	static void InsertOne() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
								  + "VALUES (?,?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			
			insertState.setInt(1, 13);
			insertState.setString(2, "123654785");
			insertState.setString(3, "아자차");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
		
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row 추가됨");
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static void InsertBank2() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
	
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
						+ "VALUES (?,?,?,?,?,?)";
				PreparedStatement insertState = con.prepareStatement(insertQuery);
				
				insertState.setInt(1, 14);
				insertState.setString(2, "1593574562");
				insertState.setString(3, "마바사");
				insertState.setDouble(4, 1300.00);
				insertState.setString(5, "kh");
				insertState.setDate(6, Date.valueOf("2023-10-15"));
				
				int rowsInsert = insertState.executeUpdate();
				System.out.println(rowsInsert + "row 추가 됨");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	static void Insertkhcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "153123";
	
				try {
					Connection con = DriverManager.getConnection(url, user, password);
					System.out.println("DB 연동 성공!");
					
					String InsertQuery = "INSERT INTO BOOK (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, created_date, updated_date, is_available)"
										+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement insertState = con.prepareStatement(InsertQuery);
					insertState.setInt(1, 21);
					insertState.setString(2, "마블코믹스 : 스파이더맨");
					insertState.setString(3, "마블");
					insertState.setInt(4, 2024);
					insertState.setString(5, "978-8934914457");
					insertState.setString(6, "hero");
					insertState.setString(7, "스파이더맨 어벤져스 합류");
					insertState.setDouble(8, 13.99);
					insertState.setDate(9, Date.valueOf("2011-04-20"));
					insertState.setDate(10, Date.valueOf("2023-10-13"));
					insertState.setString(11, null);
					insertState.setString(12, "Y");
					
					int rowsInsert = insertState.executeUpdate();
					System.out.println(rowsInsert + "row 추가 됨");
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	static void Insertkhcafe1() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "153123";
	
				
					try {
						Connection con = DriverManager.getConnection(url, user, password);
						System.out.println("DB 연동 성공");
						String insertQuery = " INSERT INTO MENU (MENU_ID,CAFE_ID,M_NAME,PRICE,DESCRIPTION)"
											+ "VALUES(?,?,?,?,?)";
						PreparedStatement insertState = con.prepareStatement(insertQuery);
						
						insertState.setInt(1, 29);
						insertState.setInt(2, 6);
						insertState.setString(3, "초코 프라페");
						insertState.setDouble(4, 3.9);
						insertState.setString(5, "초콜릿이 듬뿍 들어간 프라페");
						
						int rowsInsert = insertState.executeUpdate();
						System.out.println(rowsInsert + "추가 완료");
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	
	
	
	
	
	
}
