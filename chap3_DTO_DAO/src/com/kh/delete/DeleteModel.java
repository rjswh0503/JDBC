package com.kh.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteModel {
	private static Connection connection;
	
	private static DeleteModel DeleteModel = null;
	private static String DB_URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "153123";
	
	
	//기본 생성자로부터 외부에서 인스턴스를 직접 생성하는 것을 방지하기 위해 private으로 선언
	
	private DeleteModel() {
		
		
	}
	
	public static DeleteModel getInstance() throws SQLException {
		
		if(DeleteModel == null) {
			DeleteModel = new DeleteModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
			
		}
		
		return DeleteModel;
		
	}
	
	public boolean DeleteDelete(DeleteDTO delete) {
		String sql = "DELETE FROM products WHERE product_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, delete.getProductId());
			
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
		
				
	}
	
	
		

}
