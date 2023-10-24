package com.kh.MVC.book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookDAO {
	private Connection cc;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "153123";
	
	
	public bookDAO() {
		try {
		 cc = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<bookDTO> getAllBook(){	
		List<bookDTO> books = new ArrayList<>();
		
		try {
			PreparedStatement st = cc.prepareStatement("SELECT * FROM BOOK WHERE book_id = 7 or book_id = 8 or book_id = 15");
			
			
			
			ResultSet result = st.executeQuery();
			while(result.next()) {
				int book_id = result.getInt("book_id");
				String title = result.getString("title");
				String author = result.getString("author");
				int publication_year = result.getInt("publication_year");
				String isbn = result.getString("isbn");
				String genre = result.getString("genre");
				String description = result.getString("description");
				double price = result.getDouble("price");
				Date publication_date = result.getDate("publication_date");
				bookDTO book = new bookDTO(book_id,title,author,publication_year, isbn, genre,description, price, publication_date);
				books.add(book);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

	
		
	

}
