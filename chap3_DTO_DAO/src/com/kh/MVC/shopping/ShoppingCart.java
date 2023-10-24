package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	//ArrayList 
	private List<ProductsDTO> cartList;
	
	//쇼핑카트 생성자
	public ShoppingCart() {
		cartList = new ArrayList<>();
	}
	
	//장바구니 목록 전달해줄 get 메서드 생성 
	public List<ProductsDTO> getCartList(){
		return cartList;
	}
	
	
	//장바구니 최종 결제 금액 메서드
	
	public double cartTotalPrice() {
		double totalPrice = 0;
		//향상된 for문을 이용해서 가격 추가
		for(ProductsDTO c : cartList) {
			totalPrice += c.getPrice();
		}
		return totalPrice;
		
	}
	
	//장바구니에 추가할 메서드 생성
	public void addCart(ProductsDTO product) {
		cartList.add(product);
		System.out.println(product.getProduct_name() + "장바구니에 추가했습니다.");
		
	}
	
	//장바구니에서 제거할 메서드 생성
	public void removeGoods(ProductsDTO product) {
		if (cartList.remove(product)) {
			System.out.println("장바구니에서 제거 했습니다.");
		}else {
			System.out.println("장바구니에 해당 제품이 없습니다.");
		}
		
	}
	
	
	
	

}
