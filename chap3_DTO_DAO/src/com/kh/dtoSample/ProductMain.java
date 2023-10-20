package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductMain {

	
	public static void main(String[] args) {
		
		//Connection에 연결할 내용 작성
		//url userName,password 
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "153123";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			//인스턴스 생성하여 view 초기화
			
			ProductView view = new ProductView();
			
			//인스턴스 생성하여 controller 초기화
			ProductController controller = new ProductController(con,view);
			
			
			controller.displayAllProducts();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	
	
	
	
	
	
}
