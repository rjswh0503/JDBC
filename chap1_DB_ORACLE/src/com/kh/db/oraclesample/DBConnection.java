package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
		
		selectkhcafe();
		
		
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
			String selectQuery = "SELECT * FROM menu";
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

}