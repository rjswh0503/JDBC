package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "khcafe";
	String pssword = "153123";
	
	public void insertCafe(String name, String address, String phone_number, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, userName, pssword);

			String sql = "INSERT INTO cafes (name,address,phone_number,operating_hours)"
						+ "VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone_number);
			ps.setString(4, operating_hours);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertMenu(int menu_id, int cafe_id, String menu_name, double price, String description) {
		Connection con;
		try {
			con = DriverManager.getConnection(url, userName, pssword);
			String sql = "INSERT INTO MENU (MENU_ID, CAFE_ID, MENU_NAME, PRICE, DESCRIPTION)"
					+ "VALUES (?,?,?,?,?) ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, menu_id);
		ps.setInt(2, cafe_id);
		ps.setString(3, menu_name);
		ps.setDouble(4, price);
		ps.setString(5, description);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
						   //매개변수 추가하기 
	public void updateCafe(String operating_hours, int cafe_id) {
		
		try {
			Connection con = DriverManager.getConnection(url, userName, pssword);
			String sql = "UPDATE cafes SET operating_hours = ? WHERE cafe_id = ?";
			PreparedStatement uc = con.prepareStatement(sql);
			uc.setString(1, operating_hours);
			uc.setInt(2, cafe_id);
			
			uc.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updateMenu(String description, int menu_id, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, pssword);
			String sql = "UPDATE menu SET description = ? WHERE menu_id = ? and cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menu_id);
			st.setInt(3, cafe_id);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updateMenu1(String M_name, double price, int cafe_id) {
		
		try {
			Connection con = DriverManager.getConnection(url, userName, pssword);
			String sql = "UPDATE menu SET M_NAME = ? AND PRICE = ? WHERE CAFE_ID = ?";
			PreparedStatement um = con.prepareStatement(sql);
			um.setString(1, M_name);
			um.setDouble(2, price);
			um.setInt(3, cafe_id);
			
			
			um.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public void deleteCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, pssword);
			String sql = "DELETE FROM cafes WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafe_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteMenu(int menu_id, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, pssword);
			String sql = "DELETE FROM MENU WHERE menu_id = ? and cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menu_id);
			st.setInt(2, cafe_id);
			
			//SQL commit; 데이터베이스 변경 사항을 영구적으로 저장하는 역할
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteOrder(int order_id,int cafe_id, int menu_id) {
		
		try {
			Connection con = DriverManager.getConnection(url, userName, pssword);
			String sql = "DELETE FROM ORDERS WHERE order_id = ? or cafe_id = ? or menu_id = ?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, order_id);
			pt.setInt(2, cafe_id);
			pt.setInt(3, menu_id);

			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//or cafe_id = ?) and menu_id = ?
	
	
	//pt.setInt(2, cafe_id);
	//pt.setInt(3, menu_id);
	//,int cafe_id,int menu_id
	
	
	
}	

