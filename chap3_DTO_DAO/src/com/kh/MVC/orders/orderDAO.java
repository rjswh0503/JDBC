package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class orderDAO {
	
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "153123";
	
	
	public orderDAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<OrderDTO> getAllOrders(){
		List<OrderDTO> Orders = new ArrayList<>();
		PreparedStatement st;
		try {
			st = connection.prepareStatement("Select * from orders");
			ResultSet result = st.executeQuery();
			while(result.next()) {
				int order_id = result.getInt("order_id");
				int cafe_id = result.getInt("cafe_id");
				int menu_id = result.getInt("menu_id");
				Date order_date = result.getDate("order_date");
				int quantity = result.getInt("quantity");
				double total_price = result.getDouble("total_price");
				
				OrderDTO order = new OrderDTO(order_id, cafe_id, menu_id, order_date, quantity,total_price);
				Orders.add(order);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Orders;
	}
	
	

	
	
	

}
