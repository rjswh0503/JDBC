package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	

	public void displayProducts(List<ProductDTO> products) {
		for(ProductDTO  p : products) { //향상된 for문
			System.out.println("product_ID : " + p.getProductId());
			System.out.println("product_Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price :" + p.getPrice());
			System.out.println("Stock_Quantity :" + p.getStockQuantity());
			System.out.println();
		}
	}
}
