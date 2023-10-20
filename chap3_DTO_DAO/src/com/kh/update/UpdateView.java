package com.kh.update;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateView {
	
	public void addUpdate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��ǰ");
		
		System.out.print("��ǰ ���� :");
		double price = sc.nextDouble();
		System.out.print("��ǰ ID :");
		int productId = sc.nextInt();
		
		
		
		//��ĳ�ʷ� ���� ��ǰ ������ ���� �߰��ϱ�
		
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
			System.out.println("������Ʈ �Ϸ�");
		}else {
			System.out.println("������Ʈ �� ���� �߻�");
		}
		
		
		sc.close();
		
	}

}
