package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khbank";
	String password = "1234";
	
	
	ShoppingCart cart;
	
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	
	}
	
	public boolean payment() {
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice();/*카트안에 최종 결제 금액 메서드 추가*/
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			//가나다 계좌 잔액 가져오기
			String balanceUser = "Select balance from bank where account_name = '가나다'";
			PreparedStatement st = connection.prepareStatement(balanceUser);
			ResultSet result = st.executeQuery();
			
			
			if(result.next()) {
				double balance = result.getDouble("balance");
				
				
				//만약에 잔액이 장바구니 총액보다 적다면
				
				
				if(balance < cartTotalPrice) {
					System.out.println("잔액이 부족합니다.");
					return false;
				}
			
				//내가 가지고 있는 잔액에서 장바구니 총 액을 빼줘야 함.
				double newBalance = balance - cartTotalPrice;
				
				
				//잔액 업데이트 하기
				String updateBalance = "UPDATE BANK SET balance WHERE account_name = '가나다'";
				PreparedStatement upst = connection.prepareStatement(updateBalance);
				upst.setDouble(1, newBalance);
				upst.executeUpdate();
				
				System.out.println("결제 완료 남은 잔액 :  " + newBalance);
				return true;
			}else {
				System.out.println("계좌를 찾을 수 없습니다. ");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	

}
