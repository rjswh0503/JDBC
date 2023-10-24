package com.kh.MVC.orders;

import java.util.Date;

public class OrderDTO {
	private int order_id;
	private int cafe_id;
	private int menu_id;
	private Date order_date;
	private int quantity;
	private double total_price;
	
	


	public OrderDTO(int order_id, int cafe_id, int menu_id, Date order_date, int quantity, double total_price){
		this.order_id = order_id;
		this.cafe_id = cafe_id;
		this.menu_id = menu_id;
		this.order_date = order_date;
		this.quantity = quantity;
		this.total_price = total_price;
		
	}
	
	
	
	
	
	
	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getCafe_id() {
		return cafe_id;
	}


	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotal_price() {
		return total_price;
	}


	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
	
	
	

}
