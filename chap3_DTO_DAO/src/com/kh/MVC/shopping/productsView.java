package com.kh.MVC.shopping;

import java.util.List;

public class productsView {
	public void showProductList(List<ProductsDTO> products) {
		for(ProductsDTO p : products) {
			System.out.println("��ǰ ID : " + p.getProduct_id());
			System.out.println("��ǰ �� : " + p.getProduct_name());
			System.out.println("���� : " + p.getPrice());
			
			System.out.println("============");
			
		}
	}
	
	//��ǰ ���� ���� �޼���
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
	

}
