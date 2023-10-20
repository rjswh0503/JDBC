package com.kh.delete;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteView {
	
	public void addDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��ǰ");
		
		System.out.println("��ǰ ID :");
		int productid = sc.nextInt();
		
		
		
		//��ĳ�ʷ� ���� ������ ���� �߰��ϱ�
		
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
			System.out.println("���� �Ϸ�");
			
		}else {
			System.out.println("���� �� ���� �߻�");
		}
		
		sc.close();
	}

}
