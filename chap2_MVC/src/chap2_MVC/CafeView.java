package chap2_MVC;

import java.util.Scanner;

public class CafeView {
	//cafeModel Ŭ������ ������ ���� ���� �ɹ������� ī�� ���� �߰���
	public CafeModel model;
	
	//next() 
	//nextInt()
	//nextLine() 
	
	
	
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����� ��� �� 
	
	public CafeView(CafeModel model) {
		this.model = model;
	}
	
	//name, address, phone, operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.print("ī���̸� : ");
		String name = sc.nextLine();
		System.out.print("ī���ּ� : ");
		String address = sc.nextLine();
		System.out.print("ī�� ����ó : ");
		String phoneNumber = sc.nextLine();
		System.out.print("��ð� :");
		String operatingHours = sc.nextLine();
		
		
		//ī�� �𵨿��� insertcafe ��� �޼��带 ������ �;��� 
		
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
		
		
	
		
		
		
		
	}

	
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ �ϼ���.");
		System.out.print("������ �޴� ���� : ");
		String description = sc.nextLine();
		
		
		System.out.print("ī�� ID :");
		int cafeId = sc.nextInt();
		
		System.out.print("�޴� ID : ");
		int menuId = sc.nextInt();
		
		
		
		
		
		
		//model �� �ִ� updatemenu�� ������ �ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.updateMenu(description, menuId, cafeId);
		System.out.println("�޴� ������ ������Ʈ �Ǿ����ϴ�.!");
		
		
	}


	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ �� ��ð��� �Է����ּ���.");
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		System.out.print("������Ʈ ��ð� : ");
		String operatingHours = sc.next();
		
		
		
		
		
		model.updateCafe(operatingHours, cafeId);
		System.out.println("������Ʈ �Ϸ�!");
		
	}
	
	
	public void updateMenu1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ ������ �Է����ּ���.");
		System.out.print("ī�� ID :");
		int cafeId = sc.nextInt();
		System.out.print("������ �޴��̸� : ");
		String menuName = sc.next();
		System.out.print("������Ʈ�� ���� : ");
		double menuPrice = sc.nextDouble();
		
		
		
		
		model.updateMenu1(menuName, menuPrice,cafeId);
		System.out.println("������Ʈ �Ϸ�!");
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public void deleteCafe() {
	Scanner sc = new Scanner(System.in);
	System.out.println("ī�並 �����ϰڽ��ϴ�.");
	System.out.print("������ ī���� ID�� �Է��ϼ��� . : ");
	int cafeId = Integer.parseInt(sc.nextLine());
	
	model.deleteCafe(cafeId);
	System.out.println("ī�䰡 ���� �Ǿ����ϴ�.");
	
		
		
		
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ϰڽ��ϴ�.");
		System.out.print("�޴��� ID�� �Է��ϼ���. : ");
		int menuId = Integer.parseInt(sc.nextLine());
		System.out.print("ī�� ID�� �Է��ϼ���. : ");
		int cafeId = Integer.parseInt(sc.nextLine());
		
		
		model.deleteMenu(menuId,cafeId);
		
		System.out.println("�޴��� ���� �Ǿ����ϴ�.");
		
	}
	
	
	public void deleteOrders() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����");
		System.out.print("������ ���� ID :");
		int orderId = Integer.parseInt(sc.nextLine());
		System.out.println("������ ī�� ID :");
		int cafeId = Integer.parseInt(sc.nextLine());
		System.out.println("������ �޴� ID :");
		int menuId = Integer.parseInt(sc.nextLine());
		
		
		model.deleteOrder(orderId,cafeId,menuId);
		System.out.println("���� �Ϸ�");
	}
	
	
	public void addMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�߰��ϰ� ���� �޴� �Է����ּ���.");
		System.out.print("�޴�ID : ");
		int menuId = sc.nextInt();
		System.out.print("ī��ID :");
		int cafeId = sc.nextInt();
		System.out.print("�޴��̸�: ");
		String menuName = sc.next();
		System.out.print("���� : ");
		double price = sc.nextDouble();
		System.out.print("���� :");
		String description = sc.next();
		
		model.insertMenu(menuId, cafeId, menuName, price, description);
		System.out.println("�߰� �Ǿ����ϴ�.");
		
		
	}
	
	
}

