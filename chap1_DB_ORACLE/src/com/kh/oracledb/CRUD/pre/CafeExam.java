package com.kh.oracledb.CRUD.pre;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CafeExam {
	public static void main(String[] args) {
		
		//SelectAll();
		//SelectMenu();
		//SelectMenu();
		//Insertcafe();
		//UpdateSample();
		UpdateSample1();
		
	}

	static void SelectAll(){
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passWord = "153123";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, passWord);
			System.out.println("DB 연결 성공!");
			String selectQuery = "Select * from cafes";
			Statement st1 = con.createStatement();
			ResultSet result = st1.executeQuery(selectQuery);
			while(result.next()) {
				int cafe_id = result.getInt("cafe_id");
				String c_name = result.getString("c_name");
				String c_address = result.getString("c_address");
				String phone_number = result.getString("phone_number");
				String operating_hours = result.getString("operating_hours");
				
				System.out.println("cafe_id : " + cafe_id + " c_name :" + c_name +  " c_address : " + c_address + 
						" phone_number : " + phone_number + " operating_hours : " + operating_hours);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
		
	
	static void SelectMenu() {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passWord = "153123";
		
		
			try {
				Connection con = DriverManager.getConnection(jdbcUrl, userName, passWord);
				System.out.println("DB 연결 성공!");
				//특정 카페의 메뉴 가져오기
				String SelectQuery = "SELECT * from cafes c  JOIN menu m on c.cafe_id = m.cafe_id where c.cafe_id = ?"; 
				
				PreparedStatement ps = con.prepareStatement(SelectQuery);
				
				
				ps.setInt(1, 4);
				ResultSet result = ps.executeQuery();
				while(result.next()) {
					int a = result.getInt("cafe_id");
					String b = result.getString("c_name");
					String c = result.getString("m_name");
					
				
				
					System.out.println("cafe_id : " + a + " c_name : " + b + " m_name :" + c);
					
				}
				
				
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

	
	static void Insertcafe() {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passWord = "153123";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, passWord);
			String insertSQL = "INSERT INTO CAFES(cafe_id, c_name,c_address,phone_number,operating_hours)"
							+ "VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(insertSQL);
			Insertcafe(ps, 24,"커피카페","경기도 안산시","031-123-4567","매일: 09:00 - 21:30");
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	static void Insertcafe(PreparedStatement ps, int cafe_id, String c_name, String c_address, String phone_number, String operating_hours)throws SQLException {
		
		ps.setInt(1, cafe_id);
		ps.setString(2, c_name);
		ps.setString(3, c_address);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		ps.executeUpdate();
		System.out.println("추가");
		
		
	}
	
	
	static void UpdateSample() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passWord = "153123";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, passWord);
			String UpdateQuery = "UPDATE MENU SET PRICE = ? WHERE cafe_id = ?";
			PreparedStatement updatePs = con.prepareStatement(UpdateQuery);
			updatePs.setDouble(1, 4.5);
			updatePs.setInt(2, 1);
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + "업데이트 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	static void UpdateSample1() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passWord = "153123";
		
		
			try {
				Connection con = DriverManager.getConnection(jdbcUrl, userName, passWord);
				System.out.println("연결 성공");
				String UpdateQuery = "UPDATE CAFES SET C_ADDRESS = ? WHERE cafe_id = ?";
				PreparedStatement updatePs = con.prepareStatement(UpdateQuery);
				updatePs.setString(1, "경기도 안성시");
				updatePs.setInt(2, 5);
				int rowsUpdate = updatePs.executeUpdate();
				System.out.println("업데이트 됨");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	static void DeleteSample() {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passWord = "153123";
		
		
			
				try {
					Connection con = DriverManager.getConnection(jdbcUrl, userName, passWord);
					System.out.println("DB접속 성공!");
					String DeleteQuery = "DELETE FROM CAFES WHERE CAFE_ID = ?"; 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
	}
	
	
	
	
	
	
}
