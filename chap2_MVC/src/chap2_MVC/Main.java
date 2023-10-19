package chap2_MVC;

public class Main {
	public static void main(String[] arsg) {
		CafeModel model = new CafeModel();
		CafeView view = new CafeView(model);
		//controller
		CafeController controller = new CafeController(model, view);
		
		
		
		
		//view.addCafeName();
		//view.updateMenu();
		//view.updateCafe();
		//view.updateMenu1();
		//view.deleteCafe();
		//view.deleteMenu();
		view.deleteOrders();
		//controller.run();
		
	}
	

}
