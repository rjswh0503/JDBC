package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank1 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String name = "khbank";
		String pw = "1234";
		
		try {
			Connection connection = DriverManager.getConnection(url, name, pw);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("전송할 ID를 입력하세요. : ");
			int fromAccountId = sc.nextInt();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
