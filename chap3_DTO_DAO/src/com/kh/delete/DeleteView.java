package com.kh.delete;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteView {
	
	public void addDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 제품");
		
		System.out.println("제품 ID :");
		int productid = sc.nextInt();
		
		
		
		//스캐너로 받은 내용을 새로 추가하기
		
		DeleteDTO DeleteProduct = new DeleteDTO(productid);
		DeleteModel deleteModel;
		
		
		boolean success = false;
		
		try {
			deleteModel = DeleteModel.getInstance();
			success = deleteModel.DeleteDelete(DeleteProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(success) {
			System.out.println("삭제 완료");
			
		}else {
			System.out.println("삭제 중 오류 발생");
		}
		
		sc.close();
	}

}
