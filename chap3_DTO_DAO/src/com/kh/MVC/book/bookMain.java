package com.kh.MVC.book;

import java.util.List;

public class bookMain {

	public static void main(String[] args) {
		bookDAO dao = new bookDAO();
		bookController controller = new bookController(dao);
		bookView view = new bookView();
		
		
		List<bookDTO> books = controller.getAllBooks();
		view.showBookList(books);
		 
		
		double totalprice = controller.calculateTotalPrice(books);
		view.showTotalPrice(totalprice);
	}
}
