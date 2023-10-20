package com.kh.MVC.Singleton.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
	
	/*
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

	
	*/
	
	private static Connection connection;
	//클래스의 인스턴스를 저장하는 싱글톤 객체 
	private static ProductModel productmodel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "153123";
	
	
	//기본 생성자로부터 외부에서 인스턴스를 직접 생성하는 것을 방지하기 위해 private으로 선언
	
	
	private ProductModel() {
		
		
		
	}
	//productModel클래스의 인스턴스를 반환하는 메서드
	//처음 호출될 때 데이터베이스에 연결을 설정하고 이후 호출에서는 이미 생성된 인스턴스를 반환
	// 싱글톤 패턴을 구현하는 방식
	public static ProductModel getInstance() throws SQLException { 
		if(productmodel == null) {
			productmodel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
			
		}
		return productmodel;
	}
	
	
	public boolean insertProduct(ProductDTO product){
		String sql = "INSERT INTO products (product_id,product_name,category,price,stock_quantity)"
				+"VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getCategory());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStockQuantity());
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
		
		
	}
}
