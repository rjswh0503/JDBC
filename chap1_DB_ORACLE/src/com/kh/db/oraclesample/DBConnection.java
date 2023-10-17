package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
		// 1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2.오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
		//							      내IP주소 :port번호
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234"; 
		Connection con = null;
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(ur1, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리 예제 
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result  = selectState.executeQuery();
			//result.next() : result 객체에서 다음 행(row)으로 이동 다음 행이 있으면 true 반환, 그렇지 않으면 false
			while(result.next()) {
//              khbank에 있는 bank 테이블 결과 집합에서 account_id를 가져옴
			int accountID = result.getInt("account_ID");
			//1. accountnumber
			int accountNumber = result.getInt("account_Number");
			String accountName = result.getString("account_name");
			double balance = result.getDouble("balance");
			//2.branchName
			String branchName = result.getString("branch_Name");
			
			//3. java.sql import Date lastTransctionDAte 가져오기
			Date LAST_TRANSACTION_DATE = result.getDate("LAST_TRANSACTION_DATE");
			System.out.println("Account_ID : " + accountID + " Account_NAME : " + accountName + " balance : " + balance + " Account_NUMBER : " + accountNumber + " branch_Name : " + branchName + " last_transaction_date :" + LAST_TRANSACTION_DATE);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
