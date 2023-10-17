package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
		
		//selectkhcafe();
		SelectWhile();
		//SelectBank();
		//Select2();
		//selectIf();
		
	}
	
	static void selectkhcafe() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "153123";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����");
			//select ����
			String selectQuery = "SELECT * FROM MENU order by price";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				int menuID = result.getInt("menu_id");
				int cafeID = result.getInt("cafe_id");
				String mName = result.getString("m_Name");
				double price = result.getDouble("price");
				String Description = result.getString("Description");
				System.out.println("menuID : " + menuID + "  m_Name : " + mName + "  price : " + price + "  Description : " + Description);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	static void SelectBank() {
		// 1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
				String driver = "oracle.jdbc.driver.OracleDriver";
				// 2.����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
				//							      ��IP�ּ� :port��ȣ
				String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "khbank";
				String password = "1234"; 
				Connection con = null;
				try {
					//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
					con = DriverManager.getConnection(ur1, user, password);
					System.out.println("�����ͺ��̽� ���� ����!");
					
					//SELECT ���� ���� 
					String selectQuery = "SELECT * FROM BANK";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result  = selectState.executeQuery();
					//result.next() : result ��ü���� ���� ��(row)���� �̵� ���� ���� ������ true ��ȯ, �׷��� ������ false
					// �� ���� ���� 
					if(!result.isBeforeFirst()) {
						System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
					}
					while(result.next()) {
//		              khbank�� �ִ� bank ���̺� ��� ���տ��� account_id�� ������
					int accountID = result.getInt("account_ID");
					//1. accountnumber
					int accountNumber = result.getInt("account_Number");
					String accountName = result.getString("account_name");
					double balance = result.getDouble("balance");
					//2.branchName
					String branchName = result.getString("branch_Name");
					
					//3. java.sql import Date lastTransctionDAte ��������
					Date LAST_TRANSACTION_DATE = result.getDate("LAST_TRANSACTION_DATE");
					System.out.println("Account_ID : " + accountID + " Account_NAME : " + accountName + " balance : " + balance + " Account_NUMBER : " + accountNumber + " branch_Name : " + branchName + " last_transaction_date :" + LAST_TRANSACTION_DATE);

					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	
	static void selectIf() {

		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectQuery = "SELECT * FROM BANK WHERE account_number = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			/*
			String[] targetAN = {"��������","��������"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			*/
			
			selectState.setString(1, "1111111111");
			ResultSet result = selectState.executeQuery();
			
			//���⿡ ��ȭ�� ������ account_id ����
			//int targetAID = 4;
			
			//���� ����
			//selectState.setInt(1, targetAID);
			
			
			
			if (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				int d = result.getInt("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("account_id :" + a + "  account_number :" + b + "  account_name :" + c + "  balance :" + d + "  branch_name :" + e + "  last_transaction_date :" + f);
			}else {
				System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	static void SelectWhile() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;
		
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB ���� ����!");
			String SelectQuery = "Select * from bank where account_name in (?,?,?) order by balance";
			PreparedStatement SelectState = con.prepareStatement(SelectQuery);
			
			
			String[] targetAN = {"������","�����","�輭��"};
			SelectState.setString(1, targetAN[0]);
			SelectState.setString(2, targetAN[1]);
			SelectState.setString(3, targetAN[2]);
			ResultSet result = SelectState.executeQuery();
			 //Char 
			// String a = result.getString("���̸�");
			// char[] charArray = ���̸�.toCharArray();
			//for(char c : charArray){
			
			
			
			
			if(!result.isBeforeFirst()) {
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}
			while(result.next()) {
				int account_id = result.getInt("account_id");
				int account_number = result.getInt("account_number");
				String account_name = result.getString("account_name");
				int balance = result.getInt("balance");
				String branch_name = result.getString("branch_name");
				Date date = result.getDate("last_transaction_date");
				System.out.println("account_id : " + account_id + " account_number : " + account_number +" account_name : " + account_name + " balance : " + balance + " branch_name :" + branch_name + " date : " + date);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	static void Select2() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			String SelectQuery = "Select * from bank where account_number = ?";
			
			PreparedStatement selectState = con.prepareStatement(SelectQuery);
			
			selectState.setString(1, "8888999000");
			ResultSet result = selectState.executeQuery();
			
			if(result.next()) {
				
				String account_id = result.getString("account_id");
				int account_number = result.getInt("account_number");
				String account_name = result.getString("account_name");
				int balance = result.getInt("balance");
				String branch_name = result.getString("branch_name");
				Date date = result.getDate("last_transaction_date");
				
				System.out.println("account_id : " + account_id + " account_number" + account_number + " account_name :" + account_name + " balance" + balance + " branch_name" + branch_name + "  date" + date);
						
				
				
				
			}else {
				
				System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
