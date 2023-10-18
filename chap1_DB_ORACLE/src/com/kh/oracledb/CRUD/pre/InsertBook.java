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
			String insertSQL = "INSERT INTO BOOK (book_id,title,author,publication_year,isbn,genre,description,price,publication_date,is_available)"
								+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps1 = con.prepareStatement(insertSQL);
			
			InsertBook(ps1,27,"�����ڹͽ�:��ũ","����",1997,"975-0316269488","comics","��ũ",13.99,Date.valueOf("1997-10-24"),"Y");
			InsertBook(ps1,28,"�����ڹͽ�:ȣũ����","����",1992,"974-0307269488","comics","ȣũ����",13.99,Date.valueOf("1992-8-24"),"Y");
			InsertBook(ps1,29,"�����ڹͽ�:��������","����",1994,"973-0348269488","comics","��������",13.99,Date.valueOf("1994-01-24"),"Y");
			InsertBook(ps1,30,"�����ڹͽ�:ĸƾ�Ƹ޸�ī","����",1987,"972-0389269488","comics","ĸƾ�Ƹ޸�ī",13.99,Date.valueOf("1987-12-24"),"Y");
			
			
			
			
			ps1.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	  static void InsertBook(PreparedStatement ps1, int book_id,String title,String author,int publication_year,String isbn,String genre,String description,double price,Date publication_date,String is_available) throws SQLException  {
		 	ps1.setInt(1, book_id);
		 	ps1.setString(2, title);
		 	ps1.setString(3, author);
		 	ps1.setInt(4, publication_year);
		 	ps1.setString(5, isbn);
		 	ps1.setString(6, genre);
		 	ps1.setString(7, description);
		 	ps1.setDouble(8, price);
		 	ps1.setDate(9, publication_date);
		 	ps1.setString(10, is_available);
		 	ps1.executeUpdate();
		 	System.out.println("�߰� �Ϸ�");
		 	
		 	
		 
		 
	 }
		
		
		
}
		


