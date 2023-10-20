package com.kh.dtoSample;
//model 과 view를 연결해주는 중간다리가 controller

import java.sql.Connection;
import java.util.List;

import com.kh.MVC.Singleton.Product.ProductDTO;
import com.kh.MVC.Singleton.Product.ProductModel;
import com.kh.MVC.Singleton.Product.ProductView;

public class ProductController {
	private ProductModel priductsmodel;
	private ProductView priductsview;
	
	
	//파라미터를 작성한 생성자
	
	public ProductController(Connection con,ProductView view) {
		this.priductsmodel = new ProductModel(con);
		this.priductsview = view;
		
		
	}
	
	//출력 메서드
	public void displayAllProducts() {
		List<ProductDTO> prodcuts = priductsmodel.getProducts();
		priductsview.displayProducts(prodcuts);
	}
	
	
	

}
