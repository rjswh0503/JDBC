package com.kh.MVC.book;

import java.util.List;

public class bookController {
	private bookDAO dao;
	
	public bookController(bookDAO dao) {
		this.dao = dao;
		
	}
	
	
	public double calculateTotalPrice(List<bookDTO> books) {
		double totalprice = 0;
		
		for(bookDTO total : books) {
			totalprice += total.getPrice();
		}
		return totalprice;
		
	}
	
	public List<bookDTO> getAllBooks(){
		return dao.getAllBook();
	}

}
