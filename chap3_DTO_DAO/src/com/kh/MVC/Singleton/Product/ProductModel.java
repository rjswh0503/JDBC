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
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü 
	private static ProductModel productmodel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "153123";
	
	
	//�⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ� ���� private���� ����
	
	
	private ProductModel() {
		
		
		
	}
	//productModelŬ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	//ó�� ȣ��� �� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
	// �̱��� ������ �����ϴ� ���
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
