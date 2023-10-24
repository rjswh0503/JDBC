package com.kh.MVC.shopping;

import java.util.List;

public class ProductsController {
	private ProductsDAO dao;
	
	
	public ProductsController(ProductsDAO dao) {
		this.dao = dao;
		
	}
	
	//�� ���� ����ϴ� �޼���
	public double calculateTotalPrice(List<ProductsDTO> products) {
		double totalPrice = 0;
		//double totalPrice = 0; > ���� for���� Ȱ���Ͽ� ������ ������ ���̱� ����
		for(ProductsDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
		
	}
	
	
	
	// ��� ��ǰ�� ����Ʈ
	
	public List<ProductsDTO> getAllProducts(){
		return dao.getAllProducts();
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
