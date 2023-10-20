package com.kh.update;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateView {
	
	public void addUpdate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 제품");
		
		System.out.print("제품 가격 :");
		double price = sc.nextDouble();
		System.out.print("제품 ID :");
		int productId = sc.nextInt();
		
		
		
		//스캐너로 받은 제품 내용을 새로 추가하기
		
		UpdateDTO UpdateProduct = new UpdateDTO(price,productId);
		UpdateModel updateModel;
		
		
		boolean success = false;
		
		
		try {
			updateModel = UpdateModel.getInstance();
			success = updateModel.UpdateUpdate(UpdateProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(success) {
			System.out.println("업데이트 완료");
		}else {
			System.out.println("업데이트 중 오류 발생");
		}
		
		
		sc.close();
		
	}

}
