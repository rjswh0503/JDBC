package chap2_MVC;

import java.util.Scanner;

public class CafeController {
	public CafeModel model;
	public CafeView view;
	
	//�𵨰� �並 ������ �� ������
	public CafeController(CafeModel model,CafeView view) {
		this.model = model;
		this.view = view;
		
	}
	
	//run 
	public void run() {
		boolean isTrue = true;
		while(isTrue) {
			
			Scanner sc = new Scanner(System.in);
			//������ ��ȣ ��� �޼���� �Է�
			System.out.println("1.ī������ �߰�");
			System.out.println("2.�޴� ���� �߰�");
			System.out.println("3.ī������ ����");
			System.out.println("4.�޴� �߰�");
			System.out.println("5.����");
			System.out.print("���ϴ� �۾��� �������ּ���. : ");
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
				System.out.println("���α׷��� ����˴ϴ�.");
				isTrue = false;
				break;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է����ּ���.");
					
			}
		}
		
		
	}
	
}
