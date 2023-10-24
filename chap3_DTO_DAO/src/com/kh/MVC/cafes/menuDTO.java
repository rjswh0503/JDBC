package com.kh.MVC.cafes;

public class menuDTO {
	private int menu_id;
	private int cafe_id;
	private double price;
	private String description;
	
	
	public menuDTO(int menu_id, int cafe_id, double price, String description) {
		this.menu_id = menu_id;
		this.cafe_id = cafe_id;
		this.price = price;
		this.description = description;
		
		
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public int getCafe_id() {
		return cafe_id;
	}


	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
