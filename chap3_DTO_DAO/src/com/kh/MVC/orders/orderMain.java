package com.kh.MVC.orders;

import java.util.List;

public class orderMain {

	public static void main(String[] args) {
		orderDAO dao = new orderDAO();
		orderController controller = new orderController(dao);
		orderView view = new orderView();
		
		
		//모든 제품 리스트 가져오기
		List<OrderDTO> orders = controller.getAllOrders();
		view.showOrderList(orders);
		
		
		double totalPrice = controller.calculateTotalPrice(orders);
		view.showTotalPrice(totalPrice);

	}

}
