package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// public Ŭ����
public class CafeModel {
	
	private Connection connection;
	
	public CafeModel(Connection connection) {
		this.connection = connection;
		
	}
	
	public List<CafeDTO> getCafes() {
		List<CafeDTO> cafes = new ArrayList<>();
		
		String Query = "SELECT *FROM cafes";
		try {
			PreparedStatement st = connection.prepareStatement(Query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				//�������� ���� ����� ����ؼ� 
				// �־��� ���� �ۼ������� ������� int cafeId = result.getInt("cafe_Id");
				// ������ dto�� Ȱ���Ͽ� ���� ����� ĸ��ȭ(��ȣ)�Ͽ� ���� DTO�� �ۼ����ش�.
				// �׸��� DTO�� �ۼ����� ��ü�� �ν��Ͻ�ȭ �Ͽ� ��ü �ȿ� �ִ� �ɹ������� ȣ���Ѵ�.
				CafeDTO cafe = new CafeDTO();
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_number"));
				cafe.setOperatingHours(result.getString("operating_hours"));
				cafes.add(cafe);
				
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cafes;
	}
	

}
