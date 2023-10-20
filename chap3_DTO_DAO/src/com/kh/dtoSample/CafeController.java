package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

//model �� view �� �������ִ� �߰��ٸ�

public class CafeController {
	private CafeModel model; //�� �ɹ�����
	private CafeView view; // �� �ɹ�����
	
	
	//�Ķ���͸� �ۼ��� ������
	public CafeController(Connection con, CafeView view) {
		this.model = new CafeModel(con);
		this.view = view;	
	}
	
	//��� �޼��� 
	
	public void displayAllCafes() {
		List<CafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
		
		
	}
}
