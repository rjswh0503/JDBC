package com.kh.MVC.book;

import java.util.List;
import java.util.Scanner;

public class bookView {
	public void showBookList(List<bookDTO> books) {
		
			
			Scanner sc = new Scanner(System.in);
			 System.out.println("å ��ȣ �Է� : ");
			 while(true) { 
				 for(bookDTO bk : books) {
						
						System.out.println(" å ��ȣ : " + bk.getBook_id());
						System.out.println(" å �̸� : " + bk.getTitle());
						System.out.println(" å ���� : " + bk.getAuthor());
						System.out.println(" å ���� : " + bk.getPrice());
						
						System.out.println("==================");
						
						
				 }
				 break;
				 
			 }
			
			
				
		}
	
	
	
	
	public void showTotalPrice(double totalprice) {
		 System.out.println("�� å ���� : " + totalprice);
		 
		 
		
	
		 
		 
		 
	}
	

}
