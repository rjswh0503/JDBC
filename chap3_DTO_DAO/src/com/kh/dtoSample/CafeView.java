package com.kh.dtoSample;

import java.util.List;

public class CafeView {
	//view ���� �ַ� void �޼��带 ����Ѵ�.
	
	public void displayCafes(List<CafeDTO> cafes) {
		for(CafeDTO  c   : cafes) {
			System.out.println("Cafe Id : " + c.getCafeId());
			System.out.println("Cafe Name : " + c.getCafeName());
			System.out.println("Address : " + c.getAddress());
			System.out.println("Phone Number : " + c.getPhoneNumber());
			System.out.println("Operating Hours : " + c.getOperatingHours());
			System.out.println();
			
			
			
		}
	}
	

}
