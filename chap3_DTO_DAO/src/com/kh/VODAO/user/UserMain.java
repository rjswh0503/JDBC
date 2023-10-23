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
		//1. DataBase 연결 url, username, password 
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
				return id > 0; // 이상이면 true
				
			}
			
			
			return false; //일치하지 않을 때 
			
		
		
		//1.db연결
		//2. sql 작성
		//3. if문 활용해서 result.next() 
		//4. return > 1 이강이면 일치
		
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
			return count > 0; //1 이상이면 true
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
				System.out.println("종료하고싶다면 특수문자 제외 [e] 입력");
				System.out.print("User ID를 입력해주세요. : ");
				String input = sc.next();
				System.out.print("email을 입력해주세요. : ");
				String email = sc.next();
				
				//만약에 e를 입력했다면 
				//if("e" == input) {
				if("e".equalsIgnoreCase(input)) {
					System.out.println("종료하겠습니다.");
					break; // break가 없으면 종료되지 않음 종료하겠습니다 만 출력
				}
				
				
				//select 문 출력하기
				
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
					//boolean ID or Email 하나가 일치하지 않는 경
					boolean idTrue = checkId(userId);
					boolean emailTrue = checkEmail(email);
					if(!idTrue && emailTrue) {
						System.out.println("일치하지 않는 User ID 입니다.");
						System.out.println();
						
					}else if(idTrue && !emailTrue) {
						System.out.println("일치하지 않는 User Email 입니다.");
						System.out.println();
					}else {
						System.out.println("일치하는 User ID와 UserEmail을 찾을 수 없습니다.");
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
			
			System.out.print("아이디를 입력 해주세요. : ");
			String userName = sc.next();
			
			System.out.println("회원가입이 거의 다 끝났습니다.");
			System.out.print("마지막으로 이메일 작성해주세요. : ");
			String email = sc.next();
			
			Date regDate = new Date(); //현재 날짜와 시간을 사용한다는 의미 
			
			
			//DB에 담기 위해 인스턴스 생성 후 작성받은 정보 저장하기
			UserVO newUser = new UserVO();
			newUser.setUser_id(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			
			//데이터가 정상적으로 들어갔는지 확인 boolean을 사용해서 확인
			
			if(userDao.createUser(newUser)) { //true
				System.out.println("회원가입이 완료 되었습니다.");
				
			}else {
				System.out.println("회원가입이 실패 하였습니다.");
			}
			
			//연결 닫기
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
