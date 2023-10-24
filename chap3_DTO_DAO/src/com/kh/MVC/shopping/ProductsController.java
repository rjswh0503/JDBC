package com.kh.MVC.shopping;

import java.util.List;

public class ProductsController {
	private ProductsDAO dao;
	
	
	public ProductsController(ProductsDAO dao) {
		this.dao = dao;
		
	}
	
	//총 가격 계산하는 메서드
	public double calculateTotalPrice(List<ProductsDTO> products) {
		double totalPrice = 0;
		//double totalPrice = 0; > 향상된 for문을 활용하여 가격을 더해줄 것이기 때문
		for(ProductsDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
		
	}
	
	
	
	// 모든 제품의 리스트
	
	public List<ProductsDTO> getAllProducts(){
		return dao.getAllProducts();
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
