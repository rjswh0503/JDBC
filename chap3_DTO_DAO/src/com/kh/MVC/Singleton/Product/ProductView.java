package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	
	/*
	public void displayProducts(List<ProductDTO> products) {
		for(ProductDTO  p : products) { //���� for��
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
		System.out.println("�� ��ǰ ������ �Է��ϼ���.");
		
		
		System.out.println("��ǰ ID :");
		int productId = sc.nextInt();
		
		System.out.println("��ǰ �̸� :");
		String productName = sc.next();
		
		System.out.println("ī�װ� : ");
		String category = sc.next();
		
		System.out.println("���� :");
		double price = sc.nextDouble();
		
		System.out.println("������ :");
		int stockQuantity = sc.nextInt();
		
		
		//��ĳ�ʷ� ���� ��ǰ ������ ���� �߰��ϱ�
		
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
			System.out.println("��ǰ�� ���������� �߰��Ǿ����ϴ�.");
		}else {
			System.out.println("��ǰ �߰� �� ������ �߻��߽��ϴ�.");
		}
		
		
		//��ĳ�� �ݱ�
		sc.close();
		
	
	}
	
	
	
	
	
}
