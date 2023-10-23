package com.kh.VODAO.user;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		//1. DataBase ���� url, username, password 
			UserMain um = new UserMain();
			//um.SelectAll();
			//um.InsertRun();
			um.SelectScanner();
			
		
	}
	
	public boolean checkId(int userId) throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khCafe";
		String dbPassword = "153123";
		
		
			Connection con1 = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
			String sql = "SELECT * FROM USERINFO WHERE user_id = ?";
			PreparedStatement st = con1.prepareStatement(sql);
			st.setInt(1, userId);
			ResultSet result = st.executeQuery();	
			if(result.next()) {
				int id = result.getInt(1);
				return id > 0; // �̻��̸� true
				
			}
			
			
			return false; //��ġ���� ���� �� 
			
		
		
		//1.db����
		//2. sql �ۼ�
		//3. if�� Ȱ���ؼ� result.next() 
		//4. return > 1 �̰��̸� ��ġ
		
	}
	
	public boolean checkEmail(String email) throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khCafe";
		String dbPassword = "153123";
		
		Connection con2 = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
		String sql = "select  Count(*) from userInfo where email = ?";
		PreparedStatement pt = con2.prepareStatement(sql);
		pt.setString(1, email);
		ResultSet result = pt.executeQuery();
		
		if(result.next()) {
			int count = result.getInt(1);
			return count > 0; //1 �̻��̸� true
		}
		
		return false;
	}
	
	
	public void SelectScanner() {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khCafe";
		String dbPassword = "153123";
		
		
		try {
			Connection cc = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("�����ϰ�ʹٸ� Ư������ ���� [e] �Է�");
				System.out.print("User ID�� �Է����ּ���. : ");
				String input = sc.next();
				System.out.print("email�� �Է����ּ���. : ");
				String email = sc.next();
				
				//���࿡ e�� �Է��ߴٸ� 
				//if("e" == input) {
				if("e".equalsIgnoreCase(input)) {
					System.out.println("�����ϰڽ��ϴ�.");
					break; // break�� ������ ������� ���� �����ϰڽ��ϴ� �� ���
				}
				
				
				//select �� ����ϱ�
				
				int userId = Integer.parseInt(input);
			
				String sql = "SELECT * FROM USERINFO WHERE user_id = ? and email = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, email);
				ResultSet rs = st.executeQuery();
				
				//select one
				if(rs.next()) {
					System.out.println("user ID : " + rs.getInt("user_id"));
					System.out.println("userName : " + rs.getString("userName"));
					System.out.println("Email : " + rs.getString("email"));
					System.out.println("Registration Date :" + rs.getDate("reg_Date"));
					System.out.println();
					
					
				}else {
					//boolean ID or Email �ϳ��� ��ġ���� �ʴ� ��
					boolean idTrue = checkId(userId);
					boolean emailTrue = checkEmail(email);
					if(!idTrue && emailTrue) {
						System.out.println("��ġ���� �ʴ� User ID �Դϴ�.");
						System.out.println();
						
					}else if(idTrue && !emailTrue) {
						System.out.println("��ġ���� �ʴ� User Email �Դϴ�.");
						System.out.println();
					}else {
						System.out.println("��ġ�ϴ� User ID�� UserEmail�� ã�� �� �����ϴ�.");
						System.out.println();
						
					}
					
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		
	}
	
	
	
	
	public void SelectAll() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khCafe";
		String dbPassword = "153123";
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
			UserDAO userDAO = new UserDAO(connection);
			
			
			List<UserVO> users = userDAO.getAllUser();
			
			for(UserVO u : users) {
				System.out.println("User ID : " + u.getUser_id());
				System.out.println("User Name : " + u.getUserName());
				System.out.println("Email : " + u.getEmail());
				System.out.println("Reg_Date : " + u.getRegDate());
				
				System.out.println();
				

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	public void InsertRun() {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khCafe";
		String dbPassword = "153123";
		
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("User ID : ");
			int userId = sc.nextInt();
			
			System.out.print("���̵� �Է� ���ּ���. : ");
			String userName = sc.next();
			
			System.out.println("ȸ�������� ���� �� �������ϴ�.");
			System.out.print("���������� �̸��� �ۼ����ּ���. : ");
			String email = sc.next();
			
			Date regDate = new Date(); //���� ��¥�� �ð��� ����Ѵٴ� �ǹ� 
			
			
			//DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
			UserVO newUser = new UserVO();
			newUser.setUser_id(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			
			//�����Ͱ� ���������� ������ Ȯ�� boolean�� ����ؼ� Ȯ��
			
			if(userDao.createUser(newUser)) { //true
				System.out.println("ȸ�������� �Ϸ� �Ǿ����ϴ�.");
				
			}else {
				System.out.println("ȸ�������� ���� �Ͽ����ϴ�.");
			}
			
			//���� �ݱ�
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
