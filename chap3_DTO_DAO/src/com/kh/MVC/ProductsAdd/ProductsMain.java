package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductsMain {
	public static void main(String[] args) {
		ProductsDAO dao = new ProductsDAO();
		ProductsController controller = new ProductsController(dao);
		productsView view = new productsView();
		
		
		//모든 제품 리스트 가지고오기
		
		List<ProductsDTO> products = controller.getAllProducts();
		view.showProductList(products);
		
		
		//최종가격 계산 가져오기
		
		double totalPrice = controller.calculateTotalPrice(products);
		view.showTotalPrice(totalPrice);
		
	}

}
