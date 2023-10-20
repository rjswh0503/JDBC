package com.kh.update;

public class UpdateDTO {
	
	private int productId;
	private double price;
	
	
	


public UpdateDTO() {
		
		
	}
	
	public UpdateDTO(double price,int productId) {
	
		this.price = price;
		this.productId =productId;
		
		
		
		
	}
	
	
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
