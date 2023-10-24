package com.kh.MVC.shopping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {
	
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "153123";
	public ProductsDAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ProductsDTO> getAllProducts(){
		List<ProductsDTO> products = new ArrayList<>();
		
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM Products where product_id = 1 or product_id = 9 or product_id = 2 or product_id = 5");
			ResultSet result = st.executeQuery();
			while(result.next()) {
				int product_id = result.getInt("product_id");
				String product_name = result.getString("product_name");
				String category = result.getString("category");
				double price = result.getDouble("price");
				int stock_quantity = result.getInt("stock_quantity");
				
				ProductsDTO product = new ProductsDTO(product_id, product_name, category, price, stock_quantity);
					products.add(product);
				
					
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
		
		
		
		
	}
}
