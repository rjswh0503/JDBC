package chap2_MVC;

import java.util.Scanner;

public class CafeController {
	public CafeModel model;
	public CafeView view;
	
	//모델과 뷰를 가지고 올 생성자
	public CafeController(CafeModel model,CafeView view) {
		this.model = model;
		this.view = view;
		
	}
	
	//run 
	public void run() {
		boolean isTrue = true;
		while(isTrue) {
			
			Scanner sc = new Scanner(System.in);
			//선택할 번호 출력 메서드로 입력
			System.out.println("1.카페정보 추가");
			System.out.println("2.메뉴 설명 추가");
			System.out.println("3.카페정보 삭제");
			System.out.println("4.메뉴 추가");
			System.out.println("5.종료");
			System.out.print("원하는 작업을 선택해주세요. : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				view.addCafeName();
				isTrue = false;
				break;
				
			case 2: 
				view.updateMenu();
				isTrue = false;
				break;
			case 3:
				view.deleteCafe();
				isTrue = false;
				break;
			case 4:
				view.addMenu();
				isTrue = false;
				break;
			case 5:
				System.out.println("프로그램이 종료됩니다.");
				isTrue = false;
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
					
			}
		}
		
		
	}
	
}
