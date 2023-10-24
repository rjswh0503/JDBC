package com.kh.MVC.book;

import java.util.List;
import java.util.Scanner;

public class bookView {
	public void showBookList(List<bookDTO> books) {
		
			
			Scanner sc = new Scanner(System.in);
			 System.out.println("책 번호 입력 : ");
			 while(true) { 
				 for(bookDTO bk : books) {
						
						System.out.println(" 책 번호 : " + bk.getBook_id());
						System.out.println(" 책 이름 : " + bk.getTitle());
						System.out.println(" 책 저자 : " + bk.getAuthor());
						System.out.println(" 책 가격 : " + bk.getPrice());
						
						System.out.println("==================");
						
						
				 }
				 break;
				 
			 }
			
			
				
		}
	
	
	
	
	public void showTotalPrice(double totalprice) {
		 System.out.println("총 책 가격 : " + totalprice);
		 
		 
		
	
		 
		 
		 
	}
	

}
