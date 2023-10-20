package com.kh.dtoSample;

//CafeDTo : 데이터 전송 객체 

//객체는 파라미터 x 
public class CafeDTO {
	/*model sql 열 형식에 맞춰 데이터를 캡슐화 하고 
	getter setter를 활용하여 데이터를 저장하고 내보내는 공간 
	*/
	
	//필드 맴버변수 작성
	private int cafeId;
	private String cafeName;
	private String address;
	private String phoneNumber;
	private String operatingHours;

	
	//생성자 
	
	//기본 생성자  메서드중에 한 종류 
	public CafeDTO() {
		
	}
	
	//2. 파라미터 값을 받을 생성자
	// 메서드 오류 나는 이유는 자바 입장에서는 둘이 똑같기 때문에 파라미터를 추가하거나 삭제 
	public CafeDTO(int cafeId, String cafeName,String address, String phoneNumber, String operatingHours) {
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
		
	}

	
	
	
	//Getter Setter 메서드 
	
	public int getCafeId() {
		return cafeId;
	}
	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}
	
	
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	
	//@Override를 활용한 toString 메서드 추가
	//void 전달할거 없이 그냥 끝
	//return 전달할게 있음
	@Override
	public String toString() {
		return "CafeDTO";
		
	}
	
	

}

