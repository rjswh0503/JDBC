package com.kh.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateModel {
	
	private static Connection connection;
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	
	private static UpdateModel UpdateModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "153123";
	
	
	
	// �⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ����� private���� ����
	
	//������ 
	private UpdateModel() {
		
		
	}
	
	public static UpdateModel getInstance() throws SQLException {
		
		if(UpdateModel == null) {
			UpdateModel = new UpdateModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);

				
		
		
		}
		return UpdateModel;
		
	}
	
	public boolean UpdateUpdate(UpdateDTO update) {
		String sql = "UPDATE PRODUCTS SET price = ? where product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, update.getPrice());
			ps.setInt(2, update.getProductId());
			
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
		

	
}
