package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
	
	
	private Connection connection;
	
	public ProductModel(Connection connection) {
		this.connection = connection;
		
	}
	
	public List<ProductDTO> getProducts(){
		List<ProductDTO> products = new ArrayList<>();
		String Query = "Select * from products";
		
		try {
			PreparedStatement pt = connection.prepareStatement(Query);
			ResultSet result = pt.executeQuery();
			while(result.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductId(result.getInt("product_id"));
				product.setProductName(result.getString("product_name"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				product.setStockQuantity(result.getInt("stock_quantity"));
				products.add(product);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
		
	}	
		
}
