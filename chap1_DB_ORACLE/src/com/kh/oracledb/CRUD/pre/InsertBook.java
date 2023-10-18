package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBook {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khCafe";
		String passWord = "153123";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, passWord);
			String insertSQL = "INSERT INTO BOOK (book_id,title,author,publication_year,isbn,genre,description,price,publication_date,created_date,is_available)"
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps1 = con.prepareStatement(insertSQL);
			
			InsertBook(ps1,25,"¸¶ºíÄÚ¹Í½º:ÇæÅ©","¸¶ºí",1997,"978-0316269488","hero","±«¹° ÇæÅ©",13.99,Date.valueOf("1997-03-24"),Date.valueOf("2023-10-18"),"Y");
			
			
			ps1.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	 static void InsertBook(PreparedStatement ps1, int book_id,String title,String author,int publication_year,String isbn,String genre,String description,double price,Date publication_date,Date created_date,String is_available) throws SQLException  {
		 	ps1.setInt(1, book_id);
		 	ps1.setString(2, title);
		 	ps1.setString(3, author);
		 	ps1.setInt(4, publication_year);
		 	ps1.setString(5, isbn);
		 	ps1.setString(6, genre);
		 	ps1.setString(7, description);
		 	ps1.setDouble(8, price);
		 	ps1.setDate(9, publication_date);
		 	ps1.setDate(10, created_date);
		 	ps1.setString(11, is_available);
		 	ps1.executeUpdate();
		 	System.out.println("Ãß°¡ ¿Ï·á");
		 	
		 	
		 
		 
	 }
		
		
		
}
		


