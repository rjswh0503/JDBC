package com.kh.MVC.orders;

import java.util.List;

public class orderController {
	private orderDAO dao;
	
	
	public orderController(orderDAO dao) {
		
		this.dao = dao;
		
	}
	
	
	public double calculateTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		
		for(OrderDTO totalp : orders) {
			totalPrice += totalp.getTotal_price();
		}
		return totalPrice;
	}
	
	
	
	public List<OrderDTO> getAllOrders(){
		return dao.getAllOrders();
	}
	
	
	

}
