package com.kh.dtoSample;
//model �� view�� �������ִ� �߰��ٸ��� controller

import java.sql.Connection;
import java.util.List;

import com.kh.MVC.Singleton.Product.ProductDTO;
import com.kh.MVC.Singleton.Product.ProductModel;
import com.kh.MVC.Singleton.Product.ProductView;

public class ProductController {
	private ProductModel priductsmodel;
	private ProductView priductsview;
	
	
	//�Ķ���͸� �ۼ��� ������
	
	public ProductController(Connection con,ProductView view) {
		this.priductsmodel = new ProductModel(con);
		this.priductsview = view;
		
		
	}
	
	//��� �޼���
	public void displayAllProducts() {
		List<ProductDTO> prodcuts = priductsmodel.getProducts();
		priductsview.displayProducts(prodcuts);
	}
	
	
	

}
