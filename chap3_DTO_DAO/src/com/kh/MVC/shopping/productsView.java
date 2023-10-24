package com.kh.MVC.shopping;

import java.util.List;

public class productsView {
	public void showProductList(List<ProductsDTO> products) {
		for(ProductsDTO p : products) {
			System.out.println("제품 ID : " + p.getProduct_id());
			System.out.println("제품 명 : " + p.getProduct_name());
			System.out.println("가격 : " + p.getPrice());
			
			System.out.println("============");
			
		}
	}
	
	//제품 최종 가격 메서드
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
	

}
