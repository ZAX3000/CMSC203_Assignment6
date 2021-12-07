
public class Assignment6Driver {

	public static void main(String[] args) 
	{
		Order r1 = new Order (8, DAY.MONDAY, new Customer ("Mary", 22));
		Order r2 = new Order (12, DAY.SATURDAY, new Customer ("John", 45));
		
		Coffee cf = new Coffee("regular Coffee", SIZE.SMALL, false,false);
		
		r1.addNewBeverage("regular Coffee", SIZE.SMALL, false,false);
		
		System.out.println(r1.getBeverage(0).weekend);
		
		System.out.println(r1.getBeverage(0).equals(cf));
		
		System.out.println(r1.getBeverage(0).getType());
		
		r2.addNewBeverage("regular Coffee", SIZE.MEDIUM, true,false);
	 	r2.addNewBeverage("Mohito", SIZE.SMALL); 
		r2.addNewBeverage("Detox", SIZE.MEDIUM,4,true); 
		
		System.out.println(r2.calcOrderTotal() + " order total");
		
		System.out.println(r2.getBeverage(0));
		System.out.println(r2.getBeverage(1));
		System.out.println(r2.getBeverage(2));
		
		BevShop bevShop = new BevShop();
		
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", SIZE.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", SIZE.LARGE,true, true);
	
		bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", SIZE.SMALL, 1, false);
		bevShop.processAlcoholOrder("Mohito", SIZE.SMALL);
		
		System.out.println(bevShop.totalMonthlySale());
		
		bevShop.sortOrders();
		
		System.out.println(bevShop);
	}

}
