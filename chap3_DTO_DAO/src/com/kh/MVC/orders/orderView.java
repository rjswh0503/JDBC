package com.kh.MVC.orders;

import java.util.List;

public class orderView {
	public void showOrderList(List<OrderDTO> orders ) {
		for(OrderDTO o : orders) {
			System.out.println("주문번호 :" + o.getOrder_id());
			System.out.println("총 수량 : " + o.getQuantity());
			System.out.println("총 가격 : " + o.getTotal_price());
			System.out.println("=================");
			
		}
		
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("주문 총 가격 : "+ totalPrice);
		
	}

}
