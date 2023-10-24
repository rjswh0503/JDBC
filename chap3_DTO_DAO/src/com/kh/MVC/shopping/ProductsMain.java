package com.kh.MVC.shopping;

import java.util.List;
import java.util.Scanner;

public class ProductsMain {
	public static void main(String[] args) {
		ProductsDAO dao = new ProductsDAO();
		ProductsController controller = new ProductsController(dao);
		
		
		productsView view = new productsView();
		
		List<ProductsDTO> products = controller.getAllProducts();
		
		
		Scanner sc = new Scanner(System.in);
		// 쇼핑카트 인스턴스 생성 자리 
		ShoppingCart cart = new ShoppingCart();
	
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			//모든 제품 리스트 가지고오기
			
			//List<ProductsDTO> products = controller.getAllProducts();
			view.showProductList(products);
		
		
		case 2:
			
			
			
			//최종가격 계산 가져오기
			
			double totalPrice = controller.calculateTotalPrice(products);
			view.showTotalPrice(totalPrice);
			
			
			
		case 3:
			//제품 추가
			System.out.println("장바구니에 추가할 제품의 ID를 입력하세요. : ");
			//제품 아이디 입력 받기 
			int productId = sc.nextInt();
			//향상된 for문과 if문을 활용해서 제품 담기
			for(ProductsDTO p : products) {
				if(p.getProduct_id() == productId) {
					//카트에 추가 
					cart.addCart(p);
					System.out.println(p.getProduct_name() + "을 장바구니에 담았습니다.");
					break;
				}
			}
			
			
		case 4:
			//제거 
			System.out.println("장바구니에서 제거할 제품 ID를 입력하세요. : ");
			int removeProductId = sc.nextInt();
			for(ProductsDTO r  : cart.getCartList()) {
				if(r.getProduct_id() == removeProductId) {
					cart.removeGoods(r);
					break;
				}
			}
			
			
			
			
		
		case 5:
			//결제
			UserPay pay = new UserPay(cart);
			boolean payResult = pay.payment();
			if(payResult) {
				//카트 비우기 cart
			}
			break;
			
			
			
			
		default:
			System.out.println("잘못된 선택입니다.");
		
		}
	}

}
