package chap2_MVC;

import java.util.Scanner;

public class CafeView {
	//cafeModel 클래스를 가지고 오기 위해 맴버변수로 카페 모델을 추가함
	public CafeModel model;
	
	//next() 
	//nextInt()
	//nextLine() 
	
	
	
	
	//model 매개변수를 받을 수 있는 생성자를 만들어 줘야 함 
	
	public CafeView(CafeModel model) {
		this.model = model;
	}
	
	//name, address, phone, operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.print("카페이름 : ");
		String name = sc.nextLine();
		System.out.print("카페주소 : ");
		String address = sc.nextLine();
		System.out.print("카페 연락처 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("운영시간 :");
		String operatingHours = sc.nextLine();
		
		
		//카페 모델에서 insertcafe 라는 메서드를 가지고 와야함 
		
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
		
		
	
		
		
		
		
	}

	
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트 하세요.");
		System.out.print("수정할 메뉴 설명 : ");
		String description = sc.nextLine();
		
		
		System.out.print("카페 ID :");
		int cafeId = sc.nextInt();
		
		System.out.print("메뉴 ID : ");
		int menuId = sc.nextInt();
		
		
		
		
		
		
		//model 에 있는 updatemenu를 가지고 와서 사용자가 작성한 수정 내용 추가하기
		model.updateMenu(description, menuId, cafeId);
		System.out.println("메뉴 설명이 업데이트 되었습니다.!");
		
		
	}


	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("업데이트 할 운영시간을 입력해주세요.");
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		System.out.print("업데이트 운영시간 : ");
		String operatingHours = sc.next();
		
		
		
		
		
		model.updateCafe(operatingHours, cafeId);
		System.out.println("업데이트 완료!");
		
	}
	
	
	public void updateMenu1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("업데이트 내용을 입력해주세요.");
		System.out.print("카페 ID :");
		int cafeId = sc.nextInt();
		System.out.print("변경할 메뉴이름 : ");
		String menuName = sc.next();
		System.out.print("업데이트할 가격 : ");
		double menuPrice = sc.nextDouble();
		
		
		
		
		model.updateMenu1(menuName, menuPrice,cafeId);
		System.out.println("업데이트 완료!");
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public void deleteCafe() {
	Scanner sc = new Scanner(System.in);
	System.out.println("카페를 삭제하겠습니다.");
	System.out.print("삭제할 카페의 ID를 입력하세요 . : ");
	int cafeId = Integer.parseInt(sc.nextLine());
	
	model.deleteCafe(cafeId);
	System.out.println("카페가 삭제 되었습니다.");
	
		
		
		
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제하겠습니다.");
		System.out.print("메뉴의 ID를 입력하세요. : ");
		int menuId = Integer.parseInt(sc.nextLine());
		System.out.print("카페 ID를 입력하세요. : ");
		int cafeId = Integer.parseInt(sc.nextLine());
		
		
		model.deleteMenu(menuId,cafeId);
		
		System.out.println("메뉴가 삭제 되었습니다.");
		
	}
	
	
	public void deleteOrders() {
		Scanner sc = new Scanner(System.in);
		System.out.println("오더 삭제");
		System.out.print("삭제할 오더 ID :");
		int orderId = Integer.parseInt(sc.nextLine());
		System.out.println("삭제할 카페 ID :");
		int cafeId = Integer.parseInt(sc.nextLine());
		System.out.println("삭제할 메뉴 ID :");
		int menuId = Integer.parseInt(sc.nextLine());
		
		
		model.deleteOrder(orderId,cafeId,menuId);
		System.out.println("삭제 완료");
	}
	
	
	public void addMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("추가하고 싶은 메뉴 입력해주세요.");
		System.out.print("메뉴ID : ");
		int menuId = sc.nextInt();
		System.out.print("카페ID :");
		int cafeId = sc.nextInt();
		System.out.print("메뉴이름: ");
		String menuName = sc.next();
		System.out.print("가격 : ");
		double price = sc.nextDouble();
		System.out.print("설명 :");
		String description = sc.next();
		
		model.insertMenu(menuId, cafeId, menuName, price, description);
		System.out.println("추가 되었습니다.");
		
		
	}
	
	
}

