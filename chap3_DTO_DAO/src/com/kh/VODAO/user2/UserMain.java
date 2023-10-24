package com.kh.VODAO.user2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.kh.VODAO.user2.UserDAO;
import com.kh.VODAO.user2.UserVO;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		um.insertRun();
		um.SelectScanner();
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
	
	public void SelectScanner() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "153123";
		
		
		
		try {
			Connection cc = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է��ϼ���.");
				System.out.print("���̵� �Է����ּ���. : ");
				String input = sc.next();
				System.out.print("��й�ȣ�� �Է����ּ���. : ");
				String userPw = sc.next();
				
				if("e".equalsIgnoreCase(input)) {
					System.out.println("����Ǿ����ϴ�.");
					break; //break�� ������  ���� ���� ���� 
				}
				
				
				//select�� ���
				
				String sql = "Select * from users where userName = ? and userpassword = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setString(1, userName);
				st.setString(2, userpassword);
				ResultSet rs = st.executeQuery();
				
				
				//select one
				if(rs.next()) {
					System.out.println("user id : " + rs.getInt("user_id"));
					System.out.println("username : " + rs.getString("userName"));
					System.out.println("userpassword : " + rs.getString("userPassword"));
					System.out.println("Registration Date : " + rs.getDate("reg_Date"));
					System.out.println();
				}else {
					boolean 
				}
				
				
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
