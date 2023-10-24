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
		// ����īƮ �ν��Ͻ� ���� �ڸ� 
		ShoppingCart cart = new ShoppingCart();
	
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			//��� ��ǰ ����Ʈ ���������
			
			//List<ProductsDTO> products = controller.getAllProducts();
			view.showProductList(products);
		
		
		case 2:
			
			
			
			//�������� ��� ��������
			
			double totalPrice = controller.calculateTotalPrice(products);
			view.showTotalPrice(totalPrice);
			
			
			
		case 3:
			//��ǰ �߰�
			System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���. : ");
			//��ǰ ���̵� �Է� �ޱ� 
			int productId = sc.nextInt();
			//���� for���� if���� Ȱ���ؼ� ��ǰ ���
			for(ProductsDTO p : products) {
				if(p.getProduct_id() == productId) {
					//īƮ�� �߰� 
					cart.addCart(p);
					System.out.println(p.getProduct_name() + "�� ��ٱ��Ͽ� ��ҽ��ϴ�.");
					break;
				}
			}
			
			
		case 4:
			//���� 
			System.out.println("��ٱ��Ͽ��� ������ ��ǰ ID�� �Է��ϼ���. : ");
			int removeProductId = sc.nextInt();
			for(ProductsDTO r  : cart.getCartList()) {
				if(r.getProduct_id() == removeProductId) {
					cart.removeGoods(r);
					break;
				}
			}
			
			
			
			
		
		case 5:
			//����
			UserPay pay = new UserPay(cart);
			boolean payResult = pay.payment();
			if(payResult) {
				//īƮ ���� cart
			}
			break;
			
			
			
			
		default:
			System.out.println("�߸��� �����Դϴ�.");
		
		}
	}

}
