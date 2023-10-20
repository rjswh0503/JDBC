package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CafeMain {

	public static void main(String[] args) {
		//Connection �� ������ ���� �ۼ�
		//url userName,password 
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "153123";
		
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			//�ν��Ͻ� �����Ͽ� view �ʱ�ȭ
			
			CafeView view = new CafeView();
			
			
			
			//�ν��Ͻ� �����Ͽ� controller �ʱ�ȭ
			
			CafeController controller = new CafeController(con,view);
			
			//ī�� ���� ǥ���ϴ� �޼��� ��������
			controller.displayAllCafes();
			
			//connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
