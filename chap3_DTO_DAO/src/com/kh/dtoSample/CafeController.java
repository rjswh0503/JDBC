package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

//model 과 view 를 연결해주는 중간다리

public class CafeController {
	private CafeModel model; //모델 맴버변수
	private CafeView view; // 뷰 맴버변수
	
	
	//파라미터를 작성한 생성자
	public CafeController(Connection con, CafeView view) {
		this.model = new CafeModel(con);
		this.view = view;	
	}
	
	//출력 메서드 
	
	public void displayAllCafes() {
		List<CafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
		
		
	}
}
