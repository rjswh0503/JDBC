package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	
	/*
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
	*/
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("새 제품 정보를 입력하세요.");
		
		
		System.out.println("제품 ID :");
		int productId = sc.nextInt();
		
		System.out.println("제품 이름 :");
		String productName = sc.next();
		
		System.out.println("카테고리 : ");
		String category = sc.next();
		
		System.out.println("가격 :");
		double price = sc.nextDouble();
		
		System.out.println("재고수량 :");
		int stockQuantity = sc.nextInt();
		
		
		//스캐너로 받은 제품 내용을 새로 추가하기
		
		ProductDTO newProduct = new ProductDTO(productId,productName,category,price,stockQuantity);
		
		ProductModel productModel;
		boolean success = false;
		
		
		
		try {
			productModel = ProductModel.getInstance();
			success = productModel.insertProduct(newProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(success) {
			System.out.println("제품이 성공적으로 추가되었습니다.");
		}else {
			System.out.println("제품 추가 중 오류가 발생했습니다.");
		}
		
		
		//스캐너 닫기
		sc.close();
		
	
	}
	
	
	
	
	
}
