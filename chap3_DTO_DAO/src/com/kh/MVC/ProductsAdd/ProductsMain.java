package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductsMain {
	public static void main(String[] args) {
		ProductsDAO dao = new ProductsDAO();
		ProductsController controller = new ProductsController(dao);
		productsView view = new productsView();
		
		
		//��� ��ǰ ����Ʈ ���������
		
		List<ProductsDTO> products = controller.getAllProducts();
		view.showProductList(products);
		
		
		//�������� ��� ��������
		
		double totalPrice = controller.calculateTotalPrice(products);
		view.showTotalPrice(totalPrice);
		
	}

}
