package com.kh.VODAO.user2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.kh.VODAO.user2.UserDAO;
import com.kh.VODAO.user2.UserVO;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		um.insertRun();

	}
	
	
	public void insertRun() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "153123";
		
		Connection connection;
		try {
			connection = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassWord);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("User ID :");
			int userId = sc.nextInt();
			
			
			System.out.print("���̵� �Է����ּ��� :" );
			String userName = sc.next();
			
			System.out.print("��й�ȣ�� �Է����ּ���. : ");
			String userPassword = sc.next();
			

			
			Date regDate = new Date();
			
			
			UserVO newUser = new UserVO();
			
			newUser.setUser_id(userId);
			newUser.setUsername(userName);
			newUser.setUserpassword(userPassword);
			newUser.setReg_Date(regDate);
			
			
			
			if(userDao.CreateUser(newUser)) {
				System.out.println("������ ���������� ��� �Ǿ����ϴ�.");
			}else {
				System.out.println("���� ��� ���� ");
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
