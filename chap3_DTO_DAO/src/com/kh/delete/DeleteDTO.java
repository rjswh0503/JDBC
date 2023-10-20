package com.kh.delete;

public class DeleteDTO {
	
	private int productId;

	
public DeleteDTO() {
		
	}
	
	
	public DeleteDTO(int productid) {
		this.productId = productId;
		
		
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


}
