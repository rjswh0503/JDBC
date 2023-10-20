package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductMain {

	
	public static void main(String[] args) {
		
		//Connection�� ������ ���� �ۼ�
		//url userName,password 
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "153123";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			//�ν��Ͻ� �����Ͽ� view �ʱ�ȭ
			
			ProductView view = new ProductView();
			
			//�ν��Ͻ� �����Ͽ� controller �ʱ�ȭ
			ProductController controller = new ProductController(con,view);
			
			
			controller.displayAllProducts();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	
	
	
	
	
	
}
